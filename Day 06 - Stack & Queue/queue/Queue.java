package queue;

public class Queue {

    private Node first;
    private Node last;
    private int length;

    public class Node {

        int value;
        Node next;

        public Node(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }

        public Node getNext() {
            return next;
        }
    }

    public Queue(int value) {
        Node newNode = new Node(value);
        first = newNode;
        last = newNode;
        length++;
    }

    public void printQueue() {
        Node current = first;
        while (current != null) {
            System.out.print(current.value + " => ");
            current = current.next;
        }
        System.out.println("null");
    }

    public Node getFirst() {
        return first;
    }

    public Node getLast() {
        return last;
    }

    public void getLength() {
        System.out.println(length);
    }

    // Insert in the last of the queue
    public void enqueue(int value) {
        Node newNode = new Node(value);
        if (first == null && length == 0) {
            first = newNode;
            last = newNode;
        } else {
            last.next = newNode;
            last = newNode;
        }
        length++;
    }

    // Deleting the node from the first or starting
    public Node dequeue() {
        if (first == null && length == 0) {
            return null;
        }
        Node removedNode = first;
        first = first.next;
        removedNode.next = null;
        length--;
        return removedNode;
    }

}
