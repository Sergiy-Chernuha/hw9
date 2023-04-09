package global.goit;

import java.util.Arrays;

public class MyStack<T> {
    private int size = 0;
    private T[] array;

    public MyStack() {
        array = (T[]) new Object[10];
    }

    public void push(T value) {
        checkExtraSize();
        System.arraycopy(array, 0, array, 1,
                array.length-1);
        array[0] = (T) value;
        size++;
    }

    private void checkExtraSize() {
        if (array.length <= size) {
            array = Arrays.copyOf(array, array.length + (int) (array.length * 0.25));
        }
    }

    public void remove(int index) {
        if (index < size && index > 0) {
            int lastItems = size - index - 1;
            System.arraycopy(array, index + 1, array, index,
                    lastItems);
            size--;
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

    T pop() {
        T getValue = peek();
        System.arraycopy(array, 1, array, 0, --size);
        return getValue;
    }

    @Override
    public String toString() {
        return Arrays.toString(Arrays.copyOf(array, size));
    }
}
