# Java Iterable and Iterator Interfaces

## Overview
The `Iterable` and `Iterator` interfaces in Java are fundamental components of the Java Collections Framework, enabling iteration over collections of data (e.g., lists, sets, maps). They provide a standardized way to traverse elements in a collection, supporting constructs like the enhanced for loop (`for-each`) and iterator-based loops.

- **`Iterable<T>` Interface**: Implemented by classes that can be iterated over (e.g., `ArrayList`, `HashSet`). It allows objects to be the target of the `for-each` loop.
- **`Iterator<T>` Interface**: Provides methods to traverse and optionally modify a collection's elements.

Both interfaces are part of the `java.lang` (for `Iterable`) and `java.util` (for `Iterator`) packages and are generic, allowing type-safe iteration.

## `Iterable<T>` Interface

### Purpose
The `Iterable<T>` interface is implemented by classes whose instances can be iterated over using a `for-each` loop or an `Iterator`. It is the root interface for all collection classes in the Java Collections Framework (e.g., `List`, `Set`, `Queue`).

### Method
```java
Iterator<T> iterator();
```
- **Returns**: An `Iterator` object for traversing the collection's elements.
- **Role**: Enables the collection to provide an `Iterator` for accessing its elements sequentially.

### Usage
Classes like `ArrayList`, `LinkedList`, and `HashSet` implement `Iterable<T>`. Implementing this interface allows a class to be used in a `for-each` loop, which internally calls the `iterator()` method to obtain an `Iterator`.

### Example: Using `Iterable` with `ArrayList`
```java
import java.util.ArrayList;
import java.util.Iterable;

public class IterableExample {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Orange");

        // Using for-each loop (relies on Iterable)
        for (String fruit : list) {
            System.out.println(fruit);
        }
    }
}
```
**Output**:
```
Apple
Banana
Orange
```

## `Iterator<T>` Interface

### Purpose
The `Iterator<T>` interface provides methods to iterate over a collection's elements, check for the presence of more elements, and optionally remove elements during iteration.

### Methods
```java
boolean hasNext();
```
- **Returns**: `true` if there are more elements to iterate over, `false` otherwise.
- **Role**: Checks if the iteration has more elements.

```java
T next();
```
- **Returns**: The next element in the iteration.
- **Throws**: `NoSuchElementException` if no more elements exist.
- **Role**: Retrieves the next element.

```java
default void remove();
```
- **Action**: Removes the last element returned by `next()` from the underlying collection.
- **Throws**: `UnsupportedOperationException` if the collection does not support removal, `IllegalStateException` if `next()` hasn't been called yet or `remove()` is called multiple times per `next()`.
- **Role**: Allows safe removal of elements during iteration (optional operation).

### Usage
An `Iterator` is obtained by calling the `iterator()` method on an `Iterable` object. It is used in explicit iteration scenarios, such as when you need to remove elements while traversing or when more control over the iteration process is required.

### Example: Using `Iterator` with `LinkedList`
```java
import java.util.Iterator;
import java.util.LinkedList;

public class IteratorExample {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            int num = iterator.next();
            System.out.println(num);
            if (num == 2) {
                iterator.remove(); // Safely remove element
            }
        }

        System.out.println("After removal: " + list);
    }
}
```
**Output**:
```
1
2
3
After removal: [1, 3]
```

## Custom Implementation Example
You can implement `Iterable` and `Iterator` to create a custom iterable class. Below is an example of a custom array-based collection that implements `Iterable` and provides its own `Iterator`.

### Code: Custom Iterable Stack
```java
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomStack<T> implements Iterable<T> {
    private T[] items;
    private int top;
    private int maxSize;

    @SuppressWarnings("unchecked")
    public CustomStack(int size) {
        maxSize = size;
        items = (T[]) new Object[maxSize];
        top = -1;
    }

    public void push(T value) {
        if (top < maxSize - 1) {
            items[++top] = value;
        } else {
            throw new IllegalStateException("Stack Overflow");
        }
    }

    public T pop() {
        if (top >= 0) {
            T value = items[top];
            items[top--] = null;
            return value;
        } else {
            throw new IllegalStateException("Stack Underflow");
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new StackIterator();
    }

    private class StackIterator implements Iterator<T> {
        private int current = top;

        @Override
        public boolean hasNext() {
            return current >= 0;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            return items[current--];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Remove not supported");
        }
    }

    public static void main(String[] args) {
        CustomStack<String> stack = new CustomStack<>(3);
        stack.push("A");
        stack.push("B");
        stack.push("C");

        // Using for-each loop
        for (String item : stack) {
            System.out.println(item);
        }
    }
}
```
**Output**:
```
C
B
A
```

### Explanation of Custom Implementation
- **Class Structure**: `CustomStack<T>` implements `Iterable<T>`, making it compatible with `for-each` loops.
- **Iterator Implementation**: The inner `StackIterator` class implements `Iterator<T>`, providing `hasNext()` and `next()` to traverse the stack from top to bottom (LIFO order).
- **Key Points**:
  - `hasNext()` checks if `current >= 0` (elements remain).
  - `next()` returns the element at `current` and decrements `current`.
  - `remove()` is unsupported for simplicity (throws `UnsupportedOperationException`).
- **Usage**: The stack can be iterated using a `for-each` loop, which internally uses the `iterator()` method to obtain a `StackIterator`.

## Key Differences and Relationships
- **`Iterable` vs. `Iterator`**:
  - `Iterable` is implemented by the collection class and provides an `Iterator` via the `iterator()` method.
  - `Iterator` is used to traverse the collection and provides methods (`hasNext`, `next`, `remove`) for iteration control.
- **Relationship**: `Iterable` acts as a factory for `Iterator` objects. A collection implements `Iterable` to return an `Iterator` for traversal.
- **Use in `for-each` Loop**: The `for-each` loop internally calls `iterator()` on an `Iterable` object and uses the `Iterator`’s `hasNext()` and `next()` methods.

## Advantages
- **Standardization**: Enables consistent iteration across all Java collections.
- **Flexibility**: Supports both simple (`for-each`) and complex (explicit `Iterator` with removal) iteration patterns.
- **Type Safety**: Generic interfaces (`Iterable<T>`, `Iterator<T>`) ensure compile-time type checking.

## Limitations
- **Sequential Access**: `Iterator` provides only forward iteration; no direct support for random access or backward traversal (use `ListIterator` for bidirectional iteration in lists).
- **Single-Use**: An `Iterator` can only be used once; a new `Iterator` must be obtained for subsequent traversals.
- **Concurrent Modification**: Modifying a collection during iteration (outside `Iterator.remove()`) may cause `ConcurrentModificationException` in some collections (e.g., `ArrayList`).

## Time and Space Complexity
- **Time Complexity**:
  - `hasNext()`: O(1) in most implementations (checks a pointer or index).
  - `next()`: O(1) in most cases (accesses the next element).
  - `remove()`: O(1) for linked lists, O(n) for array-based collections like `ArrayList` due to shifting elements.
- **Space Complexity**:
  - `Iterator` object: O(1) for storing state (e.g., current index or node pointer).
  - Custom iterable collections: Depends on the underlying data structure (e.g., O(n) for arrays or linked lists).

## Use Cases
- **Collections Framework**: Used by `ArrayList`, `LinkedList`, `HashSet`, etc., for iteration.
- **Custom Data Structures**: Implement `Iterable` to enable `for-each` loop support in custom classes (e.g., stacks, queues, trees).
- **Data Processing**: Iterate over large datasets, filter elements, or perform transformations during traversal.

## Best Practices
- Always check `hasNext()` before calling `next()` to avoid `NoSuchElementException`.
- Use `remove()` cautiously, ensuring the collection supports it and `next()` has been called.
- Implement `Iterable` for custom collections to ensure compatibility with Java’s iteration mechanisms.
- Handle `ConcurrentModificationException` by using `Iterator.remove()` or copying the collection before modification.