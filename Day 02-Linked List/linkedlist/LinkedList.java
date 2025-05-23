package linkedlist;

public class LinkedList {

    public Node head;
    public Node tail;
    public int length;

    public LinkedList(int value) {
        Node newNode = new Node(value);
        head = newNode;
        tail = newNode;
        length = 1;
    }

    public class Node {

        public int value;
        public Node next;

        public Node(int value) {
            this.value = value;
            next = null;
            // length++;
        }
    }

    public Node getNode(int idx) {
        if (idx < 0 || idx >= length) {
            return null;
        }
        Node temp = head;
        int counter = 0;
        while (temp.next != null) {
            if (counter == idx) {
                return temp;
            }
            temp = temp.next;
            counter++;
            if (temp.next == null) {
                if (counter == idx) {
                    return temp;
                }
            }
        }
        return null;
    }

    public Node getHead() {
        if (head == null) {
            return null;
        }
        return head;
    }

    public Node getTail() {
        if (tail == null) {
            return null;
        }
        return tail;
    }

    public int getLength() {
        return length;
    }

    public void printList(String text) {
        Node temp = head;
        while (temp != null) {
            if (temp == head) {
                System.out.print("[");
            }
            if (temp.next != null) {
                System.out.print(temp.value + ", ");
            } else {
                System.out.println(temp.value + "]" + text);
            }
            temp = temp.next;
        }
    }

    // Create a node and add the node to the end
    public void append(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

    // Create a node and add the node in the starting
    public void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    // Create a node and add that node to a particular index
    public void insert(int idx, int value) {

        if (idx < 0 || idx > length) {
            System.err.println("Invalid index");
        } else {
            Node newNode = new Node(value);
            Node temp = head;
            Node pre = head;
            for (int i = 0; i <= length; i++) {
                if (idx == length) {
                    tail.next = newNode;
                    tail = newNode;
                    length++;
                    System.err.println("Inserted successfully");
                    break;
                }
                if (i == idx) {
                    if (idx == 0) {
                        newNode.next = head;
                        head = newNode;
                    } else {
                        newNode.next = pre.next;
                        pre.next = newNode;
                    }
                    length++;
                    System.err.println("Inserted successfully");
                    break;
                }
                pre = temp;
                temp = temp.next;
            }
        }
    }

    public int removeFirst() {
        if (head == null) {
            System.err.println("Invalid action!! Linked list is already empty");
            return 0;
        } else if (length == 1) {
            int val = head.value;
            head = null;
            tail = null;
            length = 0;
            return val;
        } else {
            int val = head.value;
            head = head.next;
            length--;
            return val;
        }
    }

    // Remove a particular node that exists in the linked list
    public Node removeLast() {
        if (head == null) {
            System.err.println("Invalid action!! Linked list is already empty");
            return null;
        } else if (length == 1) {
            Node val = head;
            head = null;
            tail = null;
            length = 0;
            return val;
        } else {
            Node temp = head;
            Node pre;
            while (temp.next != null) {
                pre = temp;
                temp = temp.next;
                if (temp.next == null) {
                    tail = pre;
                    tail.next = null;
                    length--;
                    return temp;
                }
            }
        }
        return null;
    }
}
