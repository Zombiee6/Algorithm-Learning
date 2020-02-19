/**
 * 数组
 */
public class MyArray {
    private int[] array;
    private int size;

    public MyArray(int cap) {
        this.array = new int[cap];
        size = 0;
    }

    public void insert(int element, int index) throws Exception {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("数组越界");
        }

        if (size > array.length) {
            resize();
        }

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public void resize() {
        int[] newArray = new int[array.length * 2];
        //copy array
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void output() {
        for (int i = 0; i < size; i++) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        MyArray myArray = new MyArray(10);
        myArray.insert(3, 0);
        myArray.insert(7, 1);
        myArray.insert(9, 2);
        myArray.insert(5, 3);
        myArray.insert(6, 1);
        myArray.output();
        //3,6,7,9,5
    }
}
