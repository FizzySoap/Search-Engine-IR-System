
package searchengine;

class MySet<T> {
    private MyList<T> elements;

    public MySet(int capacity) {
        elements = new MyList<>(capacity);
    }

    public void add(T element) {
        if (!elements.contains(element)) {
            elements.add(element);
        }
    }

    public T get(int index) {
        return elements.get(index);
    }

    public boolean contains(T element) {
        return elements.contains(element);
    }

    public int size() {
        return elements.size();
    }
}

