package ds;

/**
 * 循环队列(充分利用数组空间，避免元素整体移动)
 * @author Billy
 * @date 2020/3/1 11:32 上午
 */
public class CircularQueue {
    private int[] array;
    private int font;
    private int rear;

    public CircularQueue(int capacity) {
        this.array = new int[capacity];
    }

    public void enqueue(int element) throws RuntimeException {
        if ((rear + 1) % array.length == font) {
            throw new RuntimeException("Queue is full");
        }
        array[rear] = element;
        rear = (rear + 1) % array.length;
    }

    public int dequeue() throws RuntimeException {
        if (rear == font) {
            throw new RuntimeException("Queue is empty");
        }
        int element = array[font];
        font = (font + 1) % array.length;
        return element;
    }

    public void output() {
        for (int i = font; i != rear; i = (i + 1) % array.length) {
            System.out.println(array[i]);
        }
    }

    public static void main(String[] args) {
        CircularQueue circularQueue = new CircularQueue(6);
        circularQueue.enqueue(3);
        circularQueue.enqueue(5);
        circularQueue.enqueue(6);
        circularQueue.enqueue(8);
        circularQueue.enqueue(1);
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.dequeue();
        circularQueue.enqueue(2);
        circularQueue.enqueue(4);
        circularQueue.enqueue(9);
        circularQueue.output();
        //8,1,2,4,9
    }
}
