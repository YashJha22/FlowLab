# FlowLab

> A focused Android application built to explore modern Android architecture with Kotlin and Jetpack Compose.

FlowLab is a small, architecture-focused Android project built around a clean separation between UI, presentation, and data layers.

The project demonstrates how Jetpack Compose, ViewModel, StateFlow, Repository, dependency management, and lifecycle-aware state collection work together in a modern Android application.

---

## Overview

FlowLab follows a layered architecture where each component has a defined responsibility and data flows in one direction.

```text
┌─────────────────────┐
│     Compose UI      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│      ViewModel      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│     Repository      │
└──────────┬──────────┘
           │
           ▼
┌─────────────────────┐
│    Data Source      │
└─────────────────────┘
```

UI events travel down the stack. State travels back up as a stream.

---

## Architecture Principles

- **Layered separation** — UI, presentation, and data are kept distinct.
- **Unidirectional data flow** — UI events travel down; state is emitted back up.
- **Single abstraction for data** — The Repository provides one entry point for accessing application data.
- **Lifecycle-aware collection** — Compose collects state using `collectAsStateWithLifecycle()`.
- **Readable by design** — Each layer stays small enough to be understood on its own.

---

## Layer Responsibilities

### Compose UI

- Renders state emitted by the ViewModel.
- Emits user intents such as clicks and input events.
- Contains no business logic.

### ViewModel

- Holds and exposes UI state as `StateFlow<UiState>`.
- Survives configuration changes.
- Calls the Repository to read or update data.

### Repository

- Provides a single abstraction for accessing application data.
- Exposes `Flow` or `suspend` functions to the ViewModel.
- Hides where the data actually comes from.

### Data Source

- Provides the raw data used by the Repository.
- Has no knowledge of UI or presentation concerns.

---

## Tech Stack

| Layer | Technology |
|---|---|
| UI | Jetpack Compose |
| Presentation | ViewModel, StateFlow |
| Data | Repository pattern |
| Async | Kotlin Coroutines, Flow |
| Build | Gradle (Kotlin DSL) |
| Language | Kotlin |

---

## Project Structure

```text
app/
├── data/
│   └── repository/     # Repository implementations
├── ui/
│   ├── screen/         # Compose screens
│   ├── component/      # Reusable composables
│   └── theme/          # Material theme, colors, typography
└── viewmodel/          # ViewModels and UiState definitions
```

---

## Data Flow Example

Tracing a single user action through the layers:

1. **UI** — User interacts with a Compose screen.
2. **UI → ViewModel** — The screen sends the action to the ViewModel.
3. **ViewModel → Repository** — The ViewModel requests or updates data through the Repository.
4. **Repository → Data Source** — The Repository accesses the underlying data.
5. **Data Source → Repository** — The data source returns the requested data.
6. **Repository → ViewModel** — The Repository provides the data to the ViewModel.
7. **ViewModel → UI** — The ViewModel updates its `StateFlow`.
8. **UI** — Compose observes the updated state and recomposes through `collectAsStateWithLifecycle()`.

---

## Key Concepts

- Separation of concerns across UI, presentation, and data layers.
- `StateFlow` as the source of UI state.
- Lifecycle-aware state collection in Compose.
- Repository pattern as an abstraction over data access.
- ViewModel lifecycle and state management.
- Dependency passing between application layers.
- ViewModel creation and factories.
- Unidirectional data flow from UI events to rendered state.

---

## Testing Strategy

Testing will be introduced alongside the architecture as the project develops.

- **ViewModel** — Unit tests for state and UI behavior.
- **Repository** — Unit tests using controlled data sources.
- **Compose UI** — UI tests for screen behavior.

Testing tools and libraries will be added as required.

---

## Getting Started

### Requirements

- Android Studio (latest stable)
- JDK 17+
- Android SDK matching the project's `compileSdk`

### Build & Run

```bash
./gradlew assembleDebug
./gradlew installDebug
```

### Run Tests

```bash
./gradlew test
./gradlew connectedAndroidTest
```

---

## Project Goals

FlowLab is intentionally small. Its purpose is to provide a clear, practical reference for how modern Android application layers fit together and how state moves through the application.

The project prioritizes clear architecture, explicit dependencies, predictable state flow, and maintainable code.

---

## Development Status

**In Development**

The project is being developed incrementally, with each major architectural component introduced and integrated into the application.

---

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.