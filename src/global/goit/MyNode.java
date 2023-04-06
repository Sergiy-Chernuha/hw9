package global.goit;

public class MyNode<T> {
    private MyNode<T> prevNode;
    private T currentNodeValue;
    private MyNode<T> nextNode;

    public MyNode(MyNode<T> prevNode, T currentNodeValue, MyNode<T> nextNode) {
        this.prevNode = prevNode;
        this.currentNodeValue = currentNodeValue;
        this.nextNode = nextNode;
    }

    public MyNode<T> getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(MyNode<T> prevNode) {
        this.prevNode = prevNode;
    }

    public T getCurrentNodeValue() {
        return currentNodeValue;
    }

    public void setCurrentNodeValue(T currentNodeValue) {
        this.currentNodeValue = currentNodeValue;
    }

    public MyNode<T> getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyNode<T> nextNode) {
        this.nextNode = nextNode;
    }
}
