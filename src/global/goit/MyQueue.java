package global.goit;

import java.util.Arrays;

public class MyQueue<T> {
    private int size = 0;
    private T[] array;

    public MyQueue() {
        array = (T[]) new Object[10];
    }

    public void add(T value) {
        checkExtraSize();
        array[size] = (T) value;
        size++;
    }

    private void checkExtraSize() {
        if (array.length <= size) {
            array = Arrays.copyOf(array, array.length + (int) (array.length * 0.25));
        }
    }

    public void clear() {
        array = (T[]) new Object[]{};
        size = 0;
    }

    public int size() {
        return size;
    }

    T peek() {
        if (size == 0) {
            return null;
        }

        return array[0];
    }

    T poll() {
        T getValue = peek();
        System.arraycopy(array, 1, array, 0, --size);
        return getValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
