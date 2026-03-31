
package searchengine;

 

class MyList<T> {
//    private T[] data;
//    private int size;
//
//    @SuppressWarnings("unchecked")
//    public MyList(int capacity) {
//        data = (T[]) new Object[capacity];
//        size = 0;
//    }
//
//    public void add(T item) {
//        if (size == data.length) resize();
//        data[size++] = item;
//    }
//
//    public T get(int index) {
//        if (index < 0 || index >= size) throw new IndexOutOfBoundsException();
//        return data[index];
//    }
//
//    public int size() {
//        return size;
//    }
//
//    private void resize() {
//        T[] newData = (T[]) new Object[data.length * 2];
//        for (int i = 0; i < data.length; i++) newData[i] = data[i];
//        data = newData;
//    }
//}

    
    
    private Object[] elements;
    private int size;

    public MyList(int capacity) {
        elements = new Object[capacity];
        size = 0;
    }

    public void add(T element) {
        if (size == elements.length) {
            resize();
        }
        elements[size++] = element;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }
        return (T) elements[index];
    }

    public boolean contains(T element) {
        for (int i = 0; i < size; i++) {
            if (elements[i].equals(element)) {
                return true;
            }
        }
        return false;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        for (int i = 0; i < size; i++) {
            newElements[i] = elements[i];
        }
        elements = newElements;
    }
}

