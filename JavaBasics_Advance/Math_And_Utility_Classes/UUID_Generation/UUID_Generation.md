# UUID Generation

## Overview
The `UUID` class (`java.util.UUID`) generates universally unique identifiers (UUIDs), which are 128-bit values used as unique keys in applications like databases, distributed systems, or session management.

- **Purpose**: Create unique identifiers for objects or records.
- **DSA Relevance**: Involves unique key generation, used in hash tables, distributed systems, and data structures requiring unique identifiers.

## UUID Class
- **Key Methods**:
  - `randomUUID()`: Generates a random UUID (Type 4, based on random numbers).
  - `fromString(String name)`: Creates a UUID from a string representation.
  - `toString()`: Returns the UUID as a string (e.g., `123e4567-e89b-12d3-a456-426614174000`).
- **Structure**: A UUID is a 36-character string (32 hex digits + 4 hyphens) in the format `8-4-4-4-12`.
- **Example**:
  ```java
  UUID uuid = UUID.randomUUID();
  String id = uuid.toString(); // e.g., "123e4567-e89b-12d3-a456-426614174000"
  ```

## Key Features
- **Random UUIDs**: Generated using `Random` or `SecureRandom`, suitable for most applications.
- **Uniqueness**: Probability of collision is extremely low (2^128 possible values).
- **Use Cases**: Database primary keys, session IDs, transaction IDs.

## Best Practices
- Use `randomUUID()` for general-purpose unique identifiers.
- Store UUIDs as strings or binary data in databases (not as raw 128-bit values for portability).
- Validate UUID strings with `fromString()` to avoid `IllegalArgumentException`.
- Use `SecureRandom` for UUIDs in security-sensitive applications.
- Avoid generating UUIDs in tight loops due to performance overhead.

## Common Pitfalls
- Assuming absolute uniqueness without considering application scale.
- Not handling `IllegalArgumentException` for invalid UUID strings.
- Storing UUIDs inefficiently in databases (e.g., as strings instead of binary).
- Using UUIDs for cryptographic purposes without `SecureRandom`.
- Ignoring performance implications of frequent UUID generation.

## Practice Task
- **Task**: Generate 5 random UUIDs and validate a UUID string.
- **Solution Approach**:
  - Use `UUID.randomUUID()` to generate UUIDs.
  - Parse a UUID string with `UUID.fromString()`.
  - Handle invalid UUID strings.