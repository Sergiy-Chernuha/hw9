package global.goit.myhashmapfolder;

import global.goit.mylinckedlistfolder.MyNode;

public class MyMapNode<K, V> {
    private K key;
    private V value;
    private MyMapNode<K, V> nextNode;
    private int keysHashCode;

    public MyMapNode(K key, V value, MyMapNode<K, V> nextNode, int keysHashCode) {
        this.key = key;
        this.value = value;
        this.nextNode = nextNode;
        this.keysHashCode = keysHashCode;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public MyMapNode<K, V> getNextNode() {
        return nextNode;
    }

    public void setNextNode(MyMapNode<K, V> nextNode) {
        this.nextNode = nextNode;
    }

    public int getKeysHashCode() {
        return keysHashCode;
    }

    public void setKeysHashCode(int keysHashCode) {
        this.keysHashCode = keysHashCode;
    }

    @Override
    public String toString() {
        return key + "=" + value;
    }
}
