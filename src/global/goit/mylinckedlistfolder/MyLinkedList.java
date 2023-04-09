package global.goit.mylinckedlistfolder;

import global.goit.interfaces.MyList;

public class MyLinkedList<T> implements MyList<T> {
    private MyNode<T> first;
    private MyNode<T> last;
    private int size = 0;

    @Override
    public void add(T value) {
        if (first == null) {
            first = new MyNode<>(null, value, null);
        } else if (last == null) {
            last = new MyNode<>(first, value, null);
            first.setNextNode(last);
        } else {
            MyNode<T> localNode = new MyNode<>(last, value, null);

            last.setNextNode(localNode);
            last = localNode;
        }
        size++;
    }

    @Override
    public void remove(int index) {
        if (size == 1 && index == 0) {
            first = null;
            size--;
        } else if (size == 2 && index == 0) {
            first = last;
            first.setNextNode(null);
            last = null;
            size--;
        } else if (size == 2 && index == 1) {
            first.setNextNode(null);
            last = null;
            size--;
        } else if (size > 2 && index == 0) {
            first.getNextNode().setPrevNode(null);
            first = first.getNextNode();
            size--;
        } else if (index == size - 1) {
            last.getPrevNode().setNextNode(null);
            last = last.getPrevNode();
            size--;
        } else if (size > 2 && index > 0 && index < size - 1) {
            MyNode<T> localNode = first;

            for (int i = 0; i < size - 1; i++) {
                if (i == index) {
                    localNode.getPrevNode().setNextNode(localNode.getNextNode());
                    localNode.getNextNode().setPrevNode(localNode.getPrevNode());
                    size--;
                    break;
                }

                localNode = localNode.getNextNode();
            }
        }
    }

    @Override
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int index) {
        if (size == 0 || index >= size) {
            return null;
        }

        if (index == 0) {
            return first.getCurrentNodeValue();
        }

        if (index == size - 1) {
            return last.getCurrentNodeValue();
        }

        MyNode<T> localNode = first;
        for (int i = 0; i < size - 1; i++) {
            if (i == index) {
                return localNode.getCurrentNodeValue();
            }

            localNode = localNode.getNextNode();
        }

        return null;
    }
}
