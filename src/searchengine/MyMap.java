
package searchengine;


class MyMap<K, V> {
    private K[] keys;
    private V[] values;
    private int size;

    @SuppressWarnings("unchecked")
    public MyMap(int capacity) {
        keys = (K[]) new Object[capacity];
        values = (V[]) new Object[capacity];
        size = 0;
    }

    public void put(K key, V value) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) {
                values[i] = value;
                return;
            }
        }
        if (size == keys.length) resize();
        keys[size] = key;
        values[size] = value;
        size++;
    }

    public V get(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) return values[i];
        }
        return null;
    }

    public boolean containsKey(K key) {
        for (int i = 0; i < size; i++) {
            if (keys[i].equals(key)) return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void resize() {
        K[] newKeys = (K[]) new Object[keys.length * 2];
        V[] newValues = (V[]) new Object[values.length * 2];
        for (int i = 0; i < keys.length; i++) {
            newKeys[i] = keys[i];
            newValues[i] = values[i];
        }
        keys = newKeys;
        values = newValues;
    }
}
