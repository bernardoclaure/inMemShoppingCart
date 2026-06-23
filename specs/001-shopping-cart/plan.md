# Implementation Plan: In-Memory Shopping Cart

**Branch**: `001-shopping-cart` | **Date**: 2026-06-17 | **Spec**: specs/001-shopping-cart/spec.md

## Summary

Implement a minimal Java 21 Spring Boot web application that runs locally and serves a simple HTML UI showing a predetermined catalog of vegetables, allows users to add items to an in-memory shopping cart, view the cart with line totals and overall total, and clear the cart. No authentication or external persistence will be used.

## Technical Context

**Language/Version**: Java 21

**Primary Dependencies**: Spring Boot (starter-web, starter-thymeleaf), JUnit 5, Mockito (for testing). No database drivers.

**Storage**: In-memory only (application-scoped singleton service holding cart state per process).

**Testing**: JUnit 5 + Spring Boot Test. Unit tests for services, and integration tests for controller endpoints.

**Target Platform**: Local developer machine (Windows/macOS/Linux) running Java 21.

**Project Type**: Web service + simple HTML UI (Thymeleaf templates under src/main/resources/templates).

**Performance Goals**: N/A — single-user, development/demo focused.

**Constraints**: Must not persist data to disk or connect to external services; no authentication.

**Scale/Scope**: Single process, single runtime session, demo-level traffic.

## Constitution Check

The implementation follows the project constitution: Java 21 baseline, in-memory-only storage, no authentication/databases, and emphasis on simplicity and testability.

## Structure Decision

Use the existing Spring Boot application scaffolding in the repo. Add packages:
- `com.example.inMemShoppingCart.model` — `Item`, `CartEntry`.
- `com.example.inMemShoppingCart.service` — `CatalogService`, `ShoppingCartService`.
- `com.example.inMemShoppingCart.web` — `CartController` serving HTML pages.

Templates placed in `src/main/resources/templates/`:
- `catalog.html` — shows available items and add buttons
- `cart.html` — shows cart contents, quantities, line totals, overall total, and a "Clear cart" button

Static assets (minimal CSS/JS) in `src/main/resources/static/` if needed.

## Phase 0: Research (Resolved)

No unresolved technical unknowns. Choice: use Thymeleaf for server-side rendering since the project already contains `templates/` and Spring Boot simplifies serving HTML.

## Phase 1: Design & Contracts

Artifacts to produce:
- `data-model.md` — entity definitions (Item, CartEntry, ShoppingCart)
- `quickstart.md` — how to run locally and verify UI
- `contracts/` — none required (internal-only UI)

### Data model (summary)
- `Item`: id (String), name (String), price (BigDecimal)
- `CartEntry`: itemId (String), name (String), unitPrice (BigDecimal), quantity (int), lineTotal (BigDecimal)
- `ShoppingCart`: Map<itemId, CartEntry>, getTotal(): BigDecimal

## Phase 2: Implementation Tasks (high level)

1. Implement model classes in `model/`.
2. Implement `CatalogService` returning a fixed list of Items (carrots, lettuce, tomatoes, potatoes, broccoli).
3. Implement `ShoppingCartService` with operations: addItem(itemId), getEntries(), clear(). Keep state in a singleton Spring `@Service` bean.
4. Implement `CartController` with routes:
   - `GET /` or `/catalog` — render `catalog.html` with items
   - `POST /cart/add` — add item (form submit or fetch) then redirect to `/cart`
   - `GET /cart` — render `cart.html` with current cart contents
   - `POST /cart/clear` — clear cart and redirect to `/cart`
5. Create Thymeleaf templates `catalog.html` and `cart.html` referencing the controller model attributes.
6. Add unit tests for services and a Spring Boot integration test for the controller.
7. Update README or quickstart with run instructions.

## Quickstart (how to run locally)

1. Ensure Java 21 is installed and `JAVA_HOME` points to it.
2. Build and run with Maven wrapper:

```bash
./mvnw clean package
./mvnw spring-boot:run
```

3. Open `http://localhost:8080/` to view the catalog and add items to the cart.

## Validation / Acceptance

- Manual: Add items from catalog, verify cart aggregates quantities and shows correct totals, clear cart results in empty cart and total 0.
- Automated: Unit tests for `ShoppingCartService`, integration test for `/cart` rendering.

## Risks & Mitigations

- Risk: Keeping cart state in a singleton means shared across sessions in a real multi-user environment. Mitigation: This is an in-memory demo; document that it is single-process single-session.

## Files To Be Created/Edited

- `src/main/java/com/example/inMemShoppingCart/model/Item.java`
- `src/main/java/com/example/inMemShoppingCart/model/CartEntry.java`
- `src/main/java/com/example/inMemShoppingCart/service/CatalogService.java`
- `src/main/java/com/example/inMemShoppingCart/service/ShoppingCartService.java`
- `src/main/java/com/example/inMemShoppingCart/web/CartController.java`
- `src/main/resources/templates/catalog.html`
- `src/main/resources/templates/cart.html`
- `src/test/java/...` unit and integration test classes
- `specs/001-shopping-cart/quickstart.md` (optional)

## Next Actions

1. Implement the model, services, controller, and templates.
2. Add tests and run `./mvnw spring-boot:run` to verify UI.
3. Iterate on UI/UX as needed.

## Extension Hooks

**Optional Hook**: agent-context
Command: `/speckit.agent-context.update`
Description: Refresh agent context after planning

Prompt: Execute speckit.agent-context.update?
To execute: `/speckit.agent-context.update`
