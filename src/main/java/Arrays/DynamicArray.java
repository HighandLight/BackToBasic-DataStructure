package Arrays;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class DynamicArray implements List {
    protected static final int DEFAULT_CAPACITY = 16;
    protected static final String INDEX_BOUNDS_ERROR_MESSAGE = "The index must be gte to zero and lte to size";

    private int size;
    private int capacity;
    private int[] elements;

    // Default constructor -> 아무것도 안 쓰면 자동으로 만들어 줌
    // No-arg constructor
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    public DynamicArray(int capacity) {
        this.size = 0;
        this.capacity = capacity;
        this.elements = new int[capacity];
    }

    @Override
    public void add(int value) {
        elements[size++] = value;
    }

    @Override
    public void add(int index, int value) {
        ensureCapacity();
        ensureIndexBounds(index);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = value;
        size++;
    }

    @Override
    public void remove(int index) {
        ensureIndexBounds(index);
        System.arraycopy(elements, index + 1, elements, index, size - index - 1);
        size--;
    }

    @Override
    public int indexOf(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(int value) {
        for (int i = size - 1; i >= 0; i--) {
            if (elements[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int get(int index) {
        ensureIndexBounds(index);
        return elements[index];
    }

    @Override
    public void set(int index, int value) {
        ensureIndexBounds(index);
        elements[index] = value;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(int value) {
        for (int i = 0; i < size; i++) {
            if (elements[i] == value) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        this.size = 0;
        Arrays.fill(elements, 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public int[] toArray() {
        int[] result = new int[size];
        System.arraycopy(elements, 0, result, 0, size);
        return result;
    }

    private void ensureIndexBounds(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException(INDEX_BOUNDS_ERROR_MESSAGE);
        }
    }
    private void ensureCapacity() {
        if (size == capacity) {
            int[] newElements = new int[capacity * 2];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
            capacity *= 2;
        }
    }
}
