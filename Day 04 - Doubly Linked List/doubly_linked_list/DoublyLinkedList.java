package doubly_linked_list;

public class DoublyLinkedList {

    Node head;
    Node tail;
    public int length;

    public DoublyLinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    class Node {

        int value;
        Node prev;
        Node next;

        public Node(int value) {
            this.value = value;
        }
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.value);
            if (current.next != null) {
                System.out.print(" => ");
            }
            current = current.next;
        }
        System.out.println();
    }

    public void getHead() {
        System.out.println(head);
    }

    public void getTail() {
        System.out.println(tail);
    }

    public void getLength() {
        System.out.println(length);
    }

    public void append(int value) {
        if (head == null) {
            return;
        }
        Node newNode = new Node(value);
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
        length++;
    }

    public void prepend(int value) {
        if (head == null) {
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
        length++;
    }

    public Node removeLast() {
        if (head == null) {
            return null;
        }
        Node removedNode = tail;
        tail = tail.prev;
        // tail.next.prev = null; Not Neccessary
        tail.next = null;
        length--;
        return removedNode;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node removedNode = head;
        head = head.next;
        head.prev = null;
        length--;
        return removedNode;
    }

    public Node get(int index) {
        if (head == null || index < 0 || index >= length) {
            return null;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    public boolean set(int index, int value) {
        if (head == null || index < 0 || index >= length) {
            return false;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
        return true;
    }

    public boolean insert(int index, int value) {
        if (index < 0 || index > length) {
            return false;
        } else if (index == 0) {
            prepend(value);
            return true;
        } else if (index == length) {
            append(value);
            return true;
        }
        Node after = get(index);
        Node before = after.prev;
        Node newNode = new Node(value);
        newNode.prev = before;
        newNode.next = after;
        after.prev = newNode;
        before.next = newNode;
        length++;
        return true;
    }
}
