# `SharedCacheMode`

In Java 21, the `jakarta.persistence` package includes a set of classes and interfaces for managing persistence and object-relational mapping in Jakarta EE applications.

## `jakarta.persistance.SharedCacheMode`

`SharedCacheMode` is an enumeration within the `jakarta.persistence` package that defines the caching behavior for the shared-level cache in a persistence unit.
The second-level cache is used to store entities across multiple transactions to improve performance by reducing the need to access the database repeatedly for the same data.

The possible values of `SharedCacheMode` include:

- `ALL`: Cache all entities.
- `NONE`: Do not cache any entities.
- `ENABLE_SELECTIVE`: Cache entities for which caching is explicitly enabled.
- `DISABLE_SELECTIVE`: Cache all entities except those for which caching is explicitly disabled.
- `UNSPECIFIED`: The caching behavior is not specified and defaults to the persistence provider's setting.
