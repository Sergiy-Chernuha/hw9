package global.goit;

import global.goit.interfaces.MyList;

import java.util.Arrays;

public class MyArrayList<T> implements MyList<T> {
    private int size = 0;
    private T[] array;

    public MyArrayList() {
        array = (T[]) new Object[10];
    }

    public MyArrayList(int capacity) {
        array = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (array.length <= size) {
            array = Arrays.copyOf(array, array.length + 1);
        }
        array[size] = (T) value;
        size++;
    }

    @Override
    public void remove(int index) {

        if (index < size && index > 0) {
            int lostItems = size - index - 1;
            System.arraycopy(array, index + 1, array, index,
                    lostItems);
            array = Arrays.copyOf(array, array.length - 1);
            size--;
        }
    }

    @Override
    public void clear() {
        array = (T[]) new Object[]{};
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (index < size) {
            return array[index];
        }

        return null;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
}
