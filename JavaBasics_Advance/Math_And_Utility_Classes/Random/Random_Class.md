# Random Class

## Overview
The `Random` class (`java.util.Random`) generates pseudo-random numbers for various data types (integers, doubles, etc.). It is more flexible and controllable than `Math.random()` and suitable for non-cryptographic random number generation.

- **Purpose**: Generate random numbers for simulations, testing, or games.
- **DSA Relevance**: Random number generation is used in algorithms like randomized quicksort, Monte Carlo simulations, and data shuffling.

## Key Random Methods
- **`nextInt()`**: Returns a random `int`.
  - Example: `new Random().nextInt()` returns a value in \([-2^{31}, 2^{31}-1]\).
- **`nextInt(int bound)`**: Returns a random `int` in `[0, bound)`.
  - Example: `new Random().nextInt(10)` returns `0` to `9`.
- **`nextDouble()`**: Returns a random `double` in `[0.0, 1.0)`.
  - Example: `new Random().nextDouble()` is similar to `Math.random()`.
- **`nextBoolean()`**: Returns a random `boolean`.
  - Example: `new Random().nextBoolean()` returns `true` or `false`.
- **`setSeed(long seed)`**: Sets a seed for reproducible sequences.
  - Example: `new Random(123L)` generates the same sequence every time.

## Key Features
- **Seed**: Allows reproducible random sequences for debugging or testing.
- **Thread Safety**: Not thread-safe; use `ThreadLocalRandom` for concurrent applications.
- **Alternatives**:
  - `ThreadLocalRandom` for multi-threaded applications.
  - `SecureRandom` for cryptographic purposes.

## Best Practices
- Create one `Random` instance and reuse it for multiple calls to avoid performance overhead.
- Use `setSeed()` for reproducible results in testing.
- Use `ThreadLocalRandom` in concurrent applications to avoid contention.
- Avoid `Math.random()` for complex random number needs; use `Random` instead.
- Validate `bound` in `nextInt(bound)` to avoid `IllegalArgumentException`.

## Common Pitfalls
- Creating multiple `Random` instances unnecessarily, reducing performance.
- Using `Random` for cryptographic purposes (use `SecureRandom` instead).
- Not handling negative or zero `bound` in `nextInt(bound)`.
- Assuming thread safety in multi-threaded applications.
- Ignoring seed for reproducibility when needed.

## Practice Task
- **Task**: Generate a random array of 10 integers (0-99) and print them.
- **Solution Approach**:
  - Create a `Random` instance with a fixed seed for reproducibility.
  - Use `nextInt(100)` to generate numbers.
  - Store in an array and print.