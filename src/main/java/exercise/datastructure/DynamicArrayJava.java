package exercise.datastructure;

public class DynamicArrayJava<String> {

    private Object[] data;
    private int size;
    private int initialCapacity;

    public DynamicArrayJava(int initialCapacity) {
        this.initialCapacity = initialCapacity;
        data = new Object[initialCapacity];
    }

    public void add(String value) {
        if (size == initialCapacity) {
            resize();
        }
        data[size] = value;
        size++;
    }

    public String get(int index) {
        return (String) data[index];
    }

    public void set(int index, String value) {
        data[index] = value;
    }

    public void insert(int index, String value) {

        // check the size of the array
        if (size == initialCapacity) {
            resize();
        }

        // copy cell

        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        // insert the given element at given index
        data[index] = value;
    }

    public void delete(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(String value) {

        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return true;
            }
        }
        return false;
    }

    private void resize() {
        Object[] newArray = new Object[initialCapacity * 2];
        for (int i = 0; i < initialCapacity; i++) {
            newArray[i] = data[i];
        }
        data = newArray;
        initialCapacity = initialCapacity * 2;
    }

    public int size() {
        return size;
    }
}
