# `ValidationMode`

In Java 21, the `jakarta.persistence` package includes a set of classes and interfaces for managing persistence and object-relational mapping in Jakarta EE applications.

## `jakarta.persistence.ValidationMode`

`ValidationMode` is an enumeration within the `jakarta.persistence` package that defines the behavior for validation of entities in a persistence unit.
Entity validation ensures that entities adhere to constraints and validation rules before they are persisted to the database.

The possible values of `ValidationMode` include:

- `AUTO`: The persistence provider performs validation only if a Bean Validation provider is present in the classpath. This is the default mode.
- `CALLBACK`: Validation is performed before entities are persisted, updated, or removed, regardless of whether a Bean Validation provider is present.
- `NONE`: No validation is performed by the persistence provider.
