package ArrayList;

public class MyArrayList {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[15]; // Initial array size is 10
        size = 0; // Initial collection size is 0
    }

    public void add(Object value) {
        // Expand the array if it is full
        if (size == array.length) {
            Object[] newArray = new Object[array.length * 2];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
        }
        array[size] = value;
        size++;
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        // Shift elements after the removal
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size --;
    }

    public void clear(){
        // Release all elements and set size to 0
        for(int i = 0; i < size; i++){
            array[i] = null;
        }
        size = 0;
    }

    public int size() {
        return size;
    }

    public Object get(int index){
        if (index < 0 || index >= size){
            throw new IndexOutOfBoundsException("Incorrect index");
        }
        return array[index];
    }
}
