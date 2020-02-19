public class MyLinkList {

    private Node head;
    private Node last;
    private int size;

    public void insert(int data, int index) throws IndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("out of range");
        }
        Node insertedNode = new Node(data);
        if (size == 0) {
            //empty list
            head = insertedNode;
            last = insertedNode;
        } else if (index == 0) {
            //head
            insertedNode.next = head;
            head = insertedNode;
        } else if (index == size) {
            //last
            last.next = insertedNode;
            last = insertedNode;
        } else {
            //middle
            Node prevNode = getNodeByIndex(index - 1);
            insertedNode.next = prevNode.next;
            prevNode.next = insertedNode;
        }
        size++;
    }

    public Node remove(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("out of range");
        }
        Node removedNode = null;
        if (index == 0) {
            //head
            removedNode = head;
            head = head.next;
        } else if (index == size - 1) {
            //last
            Node prevNode = getNodeByIndex(index - 1);
            removedNode = prevNode.next;
            prevNode.next = null;
            last = prevNode;
        } else {
            //middle
            Node prevNode = getNodeByIndex(index - 1);
            removedNode = prevNode.next;
            prevNode.next = removedNode.next;
        }
        size--;
        return removedNode;
    }

    public Node getNodeByIndex(int index) throws IndexOutOfBoundsException {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("out of range");
        }
        Node currentNode = head;
        for (int i = 0; i < index; i++) {
            currentNode = currentNode.next;
        }
        return currentNode;
    }

    public void output() {
        Node currentNode = head;
        while (currentNode != null) {
            System.out.println(currentNode.data);
            currentNode = currentNode.next;
        }
    }

    public static void main(String[] args) {
        MyLinkList myLinkList = new MyLinkList();
        myLinkList.insert(3,0);
        myLinkList.insert(7,1);
        myLinkList.insert(9,2);
        myLinkList.insert(5,3);
        myLinkList.insert(6,1);
        myLinkList.remove(0);
        myLinkList.output();
        //6,7,9,5
    }

    private static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
}



