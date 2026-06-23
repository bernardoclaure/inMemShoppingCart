# Quickstart: In-Memory Shopping Cart

## Run locally

1. Open a terminal in the project root: `c:\Users\Bernardo Claure\repos\inMemShoppingCart`
2. Run the Maven wrapper:

```powershell
./mvnw clean package
./mvnw spring-boot:run
```

3. Open your browser at `http://localhost:8080/`

## Verify behavior

- The catalog page shows a list of predetermined vegetables.
- Clicking `Add to cart` for an item updates the cart.
- The cart page shows item name, unit price, quantity, and line total.
- The overall cart total equals the sum of all line totals.
- Clicking `Clear cart` empties the cart and shows a total of zero.

## Notes

- The application is in-memory only, so the cart resets when the app restarts.
- There is no authentication or external persistence.
