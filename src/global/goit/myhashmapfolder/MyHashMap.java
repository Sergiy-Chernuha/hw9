package global.goit.myhashmapfolder;

import java.util.Arrays;

public class MyHashMap<K, V> {
    private int size = 0;
    private MyMapNode<K, V>[] numberBucked;

    public MyHashMap() {
        numberBucked = new MyMapNode[10];
    }

    public void put(K key, V value) {
        int hashCode = Math.abs(key.hashCode());

        if (numberBucked[hashCode % 10] == null) {
            numberBucked[hashCode % 10] = new MyMapNode<>(key, value, null, hashCode);
            size++;
        } else {
            MyMapNode<K, V> localNode = numberBucked[hashCode % 10];

            if (localNode.getKeysHashCode() == hashCode && localNode.getKey().equals(key)) {
                localNode.setValue(value);
                return;
            }
            for (int i = 0; i < size - 1; i++) {
                if (localNode.getNextNode() == null) {
                    localNode.setNextNode(new MyMapNode<>(key, value, null, hashCode));
                    size++;
                    return;
                }

                if (localNode.getKeysHashCode() == hashCode && localNode.getKey().equals(key)) {
                    localNode.setValue(value);
                    return;
                }
                localNode = localNode.getNextNode();
            }
        }
    }

    public void remove(K key) {
        int hashCode = Math.abs(key.hashCode());
        MyMapNode<K, V> localNode = numberBucked[hashCode % 10];

        if (numberBucked[hashCode % 10] == null) {
            return;
        }
        if (localNode.getKeysHashCode() == hashCode && localNode.getKey().equals(key)) {
            if (localNode.getNextNode() == null) {
                numberBucked[hashCode % 10] = null;
            } else {
                numberBucked[hashCode % 10] = localNode.getNextNode();
            }
            size--;

            return;
        }
        while (localNode.getNextNode() != null) {

            if (localNode.getNextNode().getKeysHashCode() == hashCode && localNode.getNextNode().getKey().equals(key)) {
                if (localNode.getNextNode().getNextNode() == null) {
                    localNode.setNextNode(null);
                } else {
                    localNode.setNextNode(localNode.getNextNode().getNextNode());
                }
                size--;

                return;
            }
            localNode = localNode.getNextNode();
        }
    }

    public void clear() {
        numberBucked = new MyMapNode[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public V get(K key) {
        int hashCode = Math.abs(key.hashCode());
        MyMapNode<K, V> localNode = numberBucked[hashCode % 10];

        if (numberBucked[hashCode % 10] == null) {
            return null;
        }

        if (localNode.getKeysHashCode() == hashCode && localNode.getKey().equals(key)) {
            return localNode.getValue();
        }
        while (localNode.getNextNode() != null) {
            localNode = localNode.getNextNode();
            if (localNode.getKeysHashCode() == hashCode && localNode.getKey().equals(key)) {
                return localNode.getValue();
            }
        }

        return null;
    }

    @Override
    public String toString() {
        String[] result = new String[size];
        int i = 0;

        for (MyMapNode<K, V> node : numberBucked) {
            if (node != null) {
                result[i++] = node.getKey() + " = " + node.getValue();
                MyMapNode<K, V> localN = node;

                while (localN.getNextNode() != null) {
                    localN = localN.getNextNode();
                    result[i++] = localN.getKey() + " = " + localN.getValue();
                }
            }
        }
        return Arrays.toString(result);
    }
}
