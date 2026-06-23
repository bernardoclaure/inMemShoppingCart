<!--
Version change: unset → 1.0.0
Modified principles:
- New project-specific principles established for Java 21, in-memory operation, and no authentication/database requirements
Added sections:
- Additional Constraints
- Development Workflow
Removed sections:
- none
Templates requiring updates:
- .specify/templates/plan-template.md ✅ reviewed, generic guidance already aligned
- .specify/templates/spec-template.md ✅ reviewed, generic guidance already aligned
- .specify/templates/tasks-template.md ✅ reviewed, generic guidance already aligned
Follow-up TODOs:
- none
-->

# inMemShoppingCart Constitution

## Core Principles

### I. Java 21 Baseline
The application MUST be implemented using Java 21 as the single supported runtime and language baseline. All code, build, and execution artifacts MUST remain compatible with Java 21 and avoid reliance on newer JVM features.

### II. In-Memory Only
The system MUST operate entirely in memory for application state and behavior. No external database, persistent storage, or file-based persistence is allowed, and the application MUST NOT implement authentication.

### III. Simplicity by Design
Features MUST be kept minimal and focused on the in-memory shopping cart domain. Any addition requiring external state, external services, or authentication is out of scope unless explicitly justified and approved.

### IV. Testable and Deterministic
The application MUST include automated tests that validate core behavior and state transitions. Runtime behavior MUST remain deterministic for the supported scenarios so that tests are reliable and repeatable.

### V. Clear Runtime and Documentation
The project MUST include concise startup and usage guidance. Implementation MUST favor readable, maintainable code and explicit configuration over hidden framework behavior.

## Additional Constraints
The solution MUST be a standalone Java 21 application with an embedded runtime or server. It MUST not use any database, external storage, authentication mechanism, or third-party identity provider. All application state MUST be held in memory for the process lifetime only.

## Development Workflow
All changes MUST be verified by automated tests before merge. Code changes that increase complexity MUST include a short justification in PR description. New features MUST be evaluated against the core principle of simplicity and rejected if they require external persistence or authentication.

## Governance
This constitution governs implementation choices for the inMemShoppingCart project. Amendments MUST be documented, justified, and approved by the project owner or maintainer. The constitution is the authoritative source for project constraints, and PR review MUST verify compliance with these principles.

**Version**: 1.0.0 | **Ratified**: 2026-06-17 | **Last Amended**: 2026-06-17
