package com.example.inMemShoppingCart.web;

import com.example.inMemShoppingCart.model.Item;
import com.example.inMemShoppingCart.service.CatalogService;
import com.example.inMemShoppingCart.service.ShoppingCartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CartController {

    private final CatalogService catalogService;
    private final ShoppingCartService shoppingCartService;

    public CartController(CatalogService catalogService, ShoppingCartService shoppingCartService) {
        this.catalogService = catalogService;
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping({"/", "/catalog"})
    public String catalog(Model model) {
        model.addAttribute("items", catalogService.getItems());
        return "catalog";
    }

    @PostMapping("/cart/add")
    public String addItem(@RequestParam String itemId) {
        Item item = catalogService.findById(itemId);
        if (item != null) {
            shoppingCartService.addItem(item);
        }
        return "redirect:/cart";
    }

    @GetMapping("/cart")
    public String cart(Model model) {
        model.addAttribute("entries", shoppingCartService.getEntries());
        model.addAttribute("total", shoppingCartService.getTotal());
        model.addAttribute("empty", shoppingCartService.isEmpty());
        return "cart";
    }

    @PostMapping("/cart/clear")
    public String clearCart() {
        shoppingCartService.clear();
        return "redirect:/cart";
    }
}
