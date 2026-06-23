# Tasks: In-Memory Shopping Cart

**Input**: specs/001-shopping-cart/spec.md

## Phase 1: Setup (Shared Infrastructure)

- [ ] T001 Update `pom.xml` to target Java 21 and ensure build compatibility (pom.xml)
- [ ] T002 [P] Add Thymeleaf and Spring Web dependencies in `pom.xml` (pom.xml)

---

## Phase 2: Foundational (Blocking Prerequisites)

- [ ] T003 [P] Implement `Item` model in `src/main/java/com/example/inMemShoppingCart/model/Item.java`
- [ ] T004 [P] Implement `CartEntry` model in `src/main/java/com/example/inMemShoppingCart/model/CartEntry.java`
- [ ] T005 [P] Implement `CatalogService` in `src/main/java/com/example/inMemShoppingCart/service/CatalogService.java` (returns predetermined catalog)
- [ ] T006 [P] Implement `ShoppingCartService` in `src/main/java/com/example/inMemShoppingCart/service/ShoppingCartService.java` (in-memory cart: add, getEntries, clear)

---

## Phase 3: User Story 1 - Add vegetables to the cart (Priority: P1) 🎯 MVP

**Goal**: Allow users to add catalog items to the in-memory cart and aggregate quantities.

- [ ] T007 [US1] Implement `addItem(itemId)` behavior in `ShoppingCartService` (src/main/java/com/example/inMemShoppingCart/service/ShoppingCartService.java)
- [ ] T008 [US1] Add unit tests for `ShoppingCartService` covering add, aggregation, and line totals (src/test/java/.../ShoppingCartServiceTest.java)

---

## Phase 4: User Story 2 - View cart contents and total price (Priority: P2)

**Goal**: Show cart entries, quantities, line totals, overall total, and allow clearing the cart.

- [ ] T009 [US2] Implement `CartController` with endpoints: `GET /catalog`, `POST /cart/add`, `GET /cart`, `POST /cart/clear` (src/main/java/com/example/inMemShoppingCart/web/CartController.java)
- [ ] T010 [US2] Create `catalog.html` template in `src/main/resources/templates/catalog.html` (list items, add buttons)
- [ ] T011 [US2] Create `cart.html` template in `src/main/resources/templates/cart.html` (show entries, totals, clear button)
- [ ] T012 [US2] Add integration test verifying catalog -> add -> cart flow and clear behavior (src/test/java/.../CartControllerIntegrationTest.java)

---

## Phase 5: User Story 3 - Use a predefined vegetable catalog (Priority: P3)

**Goal**: Provide a fixed catalog with at least 5 vegetables.

- [ ] T013 [US3] Populate `CatalogService` with at least 5 vegetable items (carrots, lettuce, tomatoes, potatoes, broccoli) (src/main/java/com/example/inMemShoppingCart/service/CatalogService.java)
- [ ] T014 [US3] Add contract/unit test ensuring `CatalogService` returns the predetermined list (src/test/java/.../CatalogServiceTest.java)

---

## Phase 6: Polish & Cross-Cutting Concerns

- [ ] T015 [P] Update `specs/001-shopping-cart/quickstart.md` with run instructions and verification steps (specs/001-shopping-cart/quickstart.md)
- [ ] T016 [P] Run the application locally and verify the UI flow (`./mvnw spring-boot:run` then visit `http://localhost:8080`)

---

## Dependencies & Execution Order

- Phase 1 -> Phase 2 must complete before Phase 3+ work begins.
- Phases 3 (US1), 4 (US2), and 5 (US3) may be implemented in priority order; core services (T003-T006) block story implementation.

## Parallel Opportunities

- Tasks marked `[P]` can be worked on in parallel by different contributors (pom edits, models, tests, quickstart).
- Once foundational services are implemented (T003-T006), multiple story tasks (T007-T014) can proceed in parallel where they touch different files.

## Implementation Strategy

- MVP: Complete Phase 1-4 minimal implementation (catalog + add + view + clear) and tests, then polish catalog and quickstart.

## Notes

- All task descriptions include exact file paths to make tasks executable by an LLM or developer.
