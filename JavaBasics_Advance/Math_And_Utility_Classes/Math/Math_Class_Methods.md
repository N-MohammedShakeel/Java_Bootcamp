# Math Class Methods

## Overview
The `Math` class in Java (`java.lang.Math`) provides static methods for performing mathematical operations, such as arithmetic, trigonometry, and rounding. It is a utility class with no instances, designed for common numerical computations.

- **Purpose**: Perform mathematical calculations efficiently and accurately.
- **DSA Relevance**: Involves numerical algorithms (e.g., exponentiation, rounding), which are foundational in DSA for tasks like sorting, graph algorithms, and numerical analysis.

## Key Math Methods
- **`abs(double/int/long/float)`**: Returns the absolute value.
  - Example: `Math.abs(-5)` returns `5`.
- **`pow(double base, double exponent)`**: Returns `base` raised to `exponent`.
  - Example: `Math.pow(2, 3)` returns `8.0`.
- **`sqrt(double a)`**: Returns the square root of a non-negative number.
  - Example: `Math.sqrt(16)` returns `4.0`.
- **`random()`**: Returns a random `double` in `[0.0, 1.0)`.
  - Example: `Math.random()` returns a value like `0.723`.
- **`round(double a)`**: Rounds to the nearest `long`.
  - Example: `Math.round(3.6)` returns `4`.
- **`floor(double a)`**: Returns the largest `double` less than or equal to `a`.
  - Example: `Math.floor(3.7)` returns `3.0`.
- **`ceil(double a)`**: Returns the smallest `double` greater than or equal to `a`.
  - Example: `Math.ceil(3.2)` returns `4.0`.
- **`max/min(double/int/long/float a, b)`**: Returns the maximum/minimum of two values.
  - Example: `Math.max(5, 10)` returns `10`.
- **`sin/cos/tan(double a)`**: Trigonometric functions (angle in radians).
  - Example: `Math.sin(Math.PI / 2)` returns `1.0`.

## Key Features
- **Static Methods**: No need to instantiate `Math` (e.g., `Math.abs(-5)`).
- **Precision**: Uses `double` for most operations, handling edge cases like `NaN` and infinity.
- **Constants**: Provides `Math.PI` (3.14159...) and `Math.E` (2.71828...).
- **Edge Cases**:
  - `NaN` input often returns `NaN` (e.g., `Math.sqrt(-1)`).
  - Infinity handling: `Math.pow(0, -1)` returns `Infinity`.

## Best Practices
- Use `Math` methods for precise numerical computations instead of custom implementations.
- Check for `NaN` or `Infinity` when handling user inputs or calculations.
- Use `Math.random()` only for simple random number generation; prefer `Random` class for advanced needs.
- Combine `Math.round()` or `Math.floor()` with type casting for integer results.
- Use `Math.toRadians()` for trigonometric functions when angles are in degrees.

## Common Pitfalls
- Not handling `NaN` or `Infinity`, leading to unexpected results.
- Using `Math.random()` for cryptographic purposes (insecure; use `SecureRandom` instead).
- Ignoring precision issues with `double` (e.g., floating-point errors).
- Misusing `round()` when `floor()` or `ceil()` is needed.
- Not converting degrees to radians for trigonometric functions.

## Practice Task
- **Task**: Write a program to calculate the distance between two points \((x_1, y_1)\) and \((x_2, y_2)\) using the formula \(\sqrt{(x_2 - x_1)^2 + (y_2 - y_1)^2}\).
- **Solution Approach**:
  - Use `Math.pow()` for squaring, `Math.sqrt()` for the square root.
  - Validate inputs to avoid `NaN` or `Infinity`.
  - Print the result with two decimal places using `String.format()`.