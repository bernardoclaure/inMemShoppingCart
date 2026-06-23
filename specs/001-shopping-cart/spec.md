# Feature Specification: In-Memory Shopping Cart

**Feature Branch**: `[001-shopping-cart]`

**Created**: 2026-06-17

**Status**: Draft

**Input**: User description: "I want to create an in memory shopping cart with predetermined shopping items like some vegetables, I need that the user is able to add items and that can see the shopping cart with the list of items and the total price"

## User Scenarios & Testing *(mandatory)*

### User Story 1 - Add vegetables to the cart (Priority: P1)

A user selects one or more predetermined vegetable items and adds them to the shopping cart so the selected items can be reviewed before checkout.

**Why this priority**: This is the core value of the feature. Without adding items, the cart is not functional.

**Independent Test**: Verify that adding an item from the catalog updates the cart contents and cart total without requiring any other feature.

**Acceptance Scenarios**:

1. **Given** the app has a predefined item catalog containing vegetables, **when** the user adds a vegetable item to the cart, **then** the cart contains that item with the correct name, unit price, quantity, and line total.
2. **Given** the user adds the same vegetable item multiple times, **when** the user views the cart, **then** the cart shows the quantity aggregated for that item and updates the total price accordingly.

---

### User Story 2 - View cart contents and total price (Priority: P2)

A user can view the current shopping cart and confirm the list of selected items, the quantity of each item, and the total price for the cart.

**Why this priority**: Displaying the cart summary is required for users to validate their selections and total expense.

**Independent Test**: Add at least one item to the cart, view the cart, and confirm the displayed item details and total price.

**Acceptance Scenarios**:

1. **Given** there are items in the cart, **when** the user views the cart, **then** they see each item name, quantity, unit price, line total, and the final cart total.
2. **Given** the cart is empty, **when** the user views the cart, **then** they see a clear empty-cart state and a total price of zero.
3. **Given** there are items in the cart, **when** the user clears the cart, **then** the cart becomes empty and the total price is zero.

---

### User Story 3 - Use a predefined vegetable catalog (Priority: P3)

A user sees a fixed list of available vegetable items that can be added to the cart, including example foods like carrots, lettuce, tomatoes, potatoes, and broccoli.

**Why this priority**: The catalog defines what can be added to the cart and ensures behavior is predictable for the in-memory implementation.

**Independent Test**: Confirm that the predetermined catalog is available and that items can be selected from it.

**Acceptance Scenarios**:

1. **Given** the app starts, **when** the user inspects the catalog, **then** they see a list of predetermined vegetable items with names and prices.

---

### Edge Cases

- What happens when a user attempts to add an item not present in the predetermined catalog?
- How does the system display the cart when quantity is zero or when the cart has only one item?
- How does the cart total behave when multiple distinct items are added?

## Requirements *(mandatory)*

### Functional Requirements

- **FR-001**: The system MUST provide a predetermined shopping catalog of vegetable items with names and prices.
- **FR-002**: The system MUST allow users to add catalog items to an in-memory shopping cart.
- **FR-003**: The system MUST display the current cart contents with item name, quantity, unit price, and line total for each entry.
- **FR-004**: The system MUST calculate and display the total price for all items in the cart.
- **FR-005**: The system MUST handle an empty cart state clearly and show a total price of zero when no items are present.
- **FR-006**: The system MUST update item quantity and cart total when the same item is added more than once.
- **FR-007**: The system MUST allow the user to clear all items from the cart so it returns to an empty state with a total price of zero.

### Key Entities

- **Item**: Represents a predetermined shopping catalog entry with a name, price, and identifier.
- **CartEntry**: Represents a selected catalog item in the shopping cart, including quantity, unit price, and line total.
- **ShoppingCart**: Represents the current in-memory collection of selected cart entries and the cart total.

## Success Criteria *(mandatory)*

### Measurable Outcomes

- **SC-001**: A user can add an item from the predetermined vegetable catalog to the shopping cart and immediately see it in the cart.
- **SC-002**: The cart display correctly shows quantity, unit price, and line total for each selected item in at least 3 different add-to-cart scenarios.
- **SC-003**: The cart total equals the sum of all line totals in the cart for every tested scenario.
- **SC-004**: The empty cart state is clearly visible and shows a total of zero when no items are present.
- **SC-005**: The predetermined catalog is available at app startup and includes at least 5 vegetable items.

## Assumptions

- The application is an in-memory shopping cart feature scoped to a single Java 21 runtime and does not rely on authentication or external storage.
- The catalog of vegetables is predetermined and fixed for the initial release.
- User interaction can be provided through a simple UI or console-style interface with no external service dependencies.
- The feature is expected to work for a single active cart session during runtime only.
