/**
 * 循环队列(充分利用数组空间，避免元素整体移动)
 * @author Billy
 * @date 2020/3/1 11:32 上午
 */
public class MyQueue {
    private int[] array;
    private int font;
    private int rear;

    public MyQueue(int capacity) {
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
        MyQueue myQueue = new MyQueue(6);
        myQueue.enqueue(3);
        myQueue.enqueue(5);
        myQueue.enqueue(6);
        myQueue.enqueue(8);
        myQueue.enqueue(1);
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.dequeue();
        myQueue.enqueue(2);
        myQueue.enqueue(4);
        myQueue.enqueue(9);
        myQueue.output();
        //8,1,2,4,9
    }
}
