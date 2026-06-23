package com.example.inMemShoppingCart.web;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.junit.jupiter.api.BeforeEach;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrlPattern;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
public class CartControllerIntegrationTest {

    @Autowired
    private WebApplicationContext wac;

    private MockMvc mockMvc;

    @BeforeEach
    void setup() {
        this.mockMvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

    @Test
    void catalogAddViewClearFlow() throws Exception {
    // GET /catalog
    String catalogContent = mockMvc.perform(get("/catalog"))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
    assertThat(catalogContent).contains("Carrot").contains("Potato");

    // POST /cart/add (form encoded)
    mockMvc.perform(post("/cart/add").param("itemId", "carrot"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrlPattern("/cart*"));

    // GET /cart
    String cartContent = mockMvc.perform(get("/cart"))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
    assertThat(cartContent).contains("Carrot").contains("Quantity").contains("Total");

    // POST /cart/clear
    mockMvc.perform(post("/cart/clear").contentType("application/x-www-form-urlencoded"))
        .andExpect(status().is3xxRedirection())
        .andExpect(redirectedUrlPattern("/cart*"));

    // GET /cart after clear
    String afterContent = mockMvc.perform(get("/cart"))
        .andExpect(status().isOk())
        .andReturn().getResponse().getContentAsString();
    assertThat(afterContent).contains("Your cart is empty.").contains("$0.00");
    }
}
