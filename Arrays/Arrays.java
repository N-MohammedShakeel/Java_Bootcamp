package Java_Bootcamp.Arrays;// Java Fundamentals: Arrays
// Aligned with Oracle Certified Professional: Java SE 17 Developer syllabus

/*
1. Single and Multidimensional Arrays
------------------------------------
- Arrays:
  - Fixed-size, homogeneous collections of elements stored in contiguous memory.
  - All elements must be of the same data type (primitive or reference).
- Single-Dimensional Arrays:
  - A linear collection of elements.
  - Syntax: Type[] arrayName; or Type arrayName[];
  - Example: int[] numbers; // Declaration
- Multidimensional Arrays:
  - Arrays of arrays (e.g., 2D array is an array of 1D arrays).
  - Syntax: Type[][] arrayName; (for 2D) or Type[][][] arrayName; (for 3D)
  - Example: int[][] matrix; // 2D array
- Notes:
  - Arrays are objects in Java, stored in heap memory.
  - Multidimensional arrays in Java are not true matrices but arrays of arrays, allowing jagged arrays (rows of different lengths).
*/

/*
2. Array Initialization and Manipulation
---------------------------------------
- Initialization:
  - Declare and allocate memory: Type[] arrayName = new Type[size];
  - Initialize with values: Type[] arrayName = {value1, value2, ...};
  - Multidimensional: Type[][] arrayName = {{val1, val2}, {val3, val4}};
  - Example: int[] numbers = new int[5]; or int[] numbers = {1, 2, 3, 4, 5};
- Manipulation:
  - Access elements using index: arrayName[index] (0-based indexing).
  - Modify elements: arrayName[index] = value;
  - Get length: arrayName.length (returns size of array).
  - Example: numbers[0] = 10; // Sets first element to 10
- Notes:
  - Default values: 0 (numbers), 0.0 (floating-point), false (boolean), null (references).
  - Use loops (for, enhanced for) to iterate over arrays.
  - Multidimensional arrays accessed with multiple indices: matrix[row][col].
*/

/*
3. Array Bounds Checking
------------------------
- Java performs automatic bounds checking to ensure array indices are valid.
- Valid indices: 0 to (arrayName.length - 1).
- Out-of-bounds access throws ArrayIndexOutOfBoundsException.
- Example: int[] arr = new int[3]; arr[3] = 5; // Throws exception
- Notes:
  - Always check array length before accessing elements.
  - Multidimensional arrays require bounds checking for each dimension.
  - Use try-catch to handle potential out-of-bounds errors gracefully.
*/

public class Arrays {
    public static void main(String[] args) {
        // Example 1: Single-Dimensional Array
        System.out.println("Single-Dimensional Array:");
        // Declaration and initialization
        int[] numbers = new int[5]; // Array of size 5, default values: 0
        // Manipulation
        numbers[0] = 10;
        numbers[1] = 20;
        numbers[2] = 30;
        numbers[3] = 40;
        numbers[4] = 50;
        // Alternative initialization
        int[] moreNumbers = {1, 2, 3, 4, 5};
        // Accessing and printing
        System.out.print("Numbers: ");
        for (int i = 0; i < numbers.length; i++) {
            System.out.print(numbers[i] + " ");
        }
        System.out.println();
        System.out.print("More Numbers (Enhanced for): ");
        for (int num : moreNumbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        // Example 2: Multidimensional Array
        System.out.println("\nMultidimensional Array:");
        // 2D array initialization
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };
        // Manipulation
        matrix[1][2] = 60; // Change element at row 1, column 2
        // Accessing and printing
        System.out.println("Matrix:");
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        // Jagged array example
        int[][] jagged = new int[3][];
        jagged[0] = new int[] {1, 2};
        jagged[1] = new int[] {3, 4, 5};
        jagged[2] = new int[] {6};
        System.out.println("Jagged Array:");
        for (int[] row : jagged) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }

        // Example 3: Array Bounds Checking
        System.out.println("\nArray Bounds Checking:");
        try {
            System.out.println("Accessing valid index: " + numbers[4]); // 50
            System.out.println("Accessing invalid index: " + numbers[5]); // Throws exception
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}