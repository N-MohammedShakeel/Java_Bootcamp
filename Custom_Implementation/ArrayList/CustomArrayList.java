package Java_Bootcamp.Custom_Implementation.ArrayList;

public class CustomArrayList<E> {
    private Object[] elements;
    private int size = 0;
    private static final int INITIAL_CAPACITY = 10;

    public CustomArrayList() {
        elements = new Object[INITIAL_CAPACITY];
    }

    // Ensure capacity
    private void ensureCapacity() {
        if (size == elements.length) {
            int newCapacity = elements.length * 2;
            Object[] newArray = new Object[newCapacity];
            System.arraycopy(elements, 0, newArray, 0, size);
            elements = newArray;
        }
    }

    // Add element at the end
    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    // Add element at a specific index
    public void add(int index, E element) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index);

        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    // Get element by index
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);

        return (E) elements[index];
    }

    // Remove element by index
    public E remove(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index);

        @SuppressWarnings("unchecked")
        E removedElement = (E) elements[index];
        int moveCount = size - index - 1;
        if (moveCount > 0)
            System.arraycopy(elements, index + 1, elements, index, moveCount);

        elements[--size] = null; // Avoid memory leak
        return removedElement;
    }

    // Get current size
    public int size() {
        return size;
    }

    // String representation
    public String toString() {
        if (size == 0) return "[]";
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(elements[i]);
            if (i < size - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

class Main {
    public static void main(String[] args) {
        CustomArrayList<String> list = new CustomArrayList<>();
        list.add("Apple");
        list.add("Banana");
        list.add("Cherry");
        list.add(1, "Mango");

        System.out.println("List: " + list);
        System.out.println("Element at index 2: " + list.get(2));

        list.remove(1);
        System.out.println("After removal: " + list);
        System.out.println("Size: " + list.size());
    }
}

