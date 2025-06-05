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
                System.out.print(" <=> ");
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
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        }
        length++;
    }

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

    public Node removeLast() {
        if (head == null) {
            return null;
        }
        Node removedNode = tail;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
            removedNode.prev = null;
        }
        length--;
        return removedNode;
    }

    public Node removeFirst() {
        if (head == null) {
            return null;
        }
        Node removedNode = head;
        if (length == 1) {
            head = null;
            tail = null;
        } else {
            head = head.next;
            head.prev = null;
            removedNode.next = null;
        }
        length--;
        return removedNode;
    }

    public Node get(int index) {
        if (head == null || index < 0 || index >= length) {
            return null;
        }
        Node current = head;
        if (index < length / 2) {
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
        } else {
            current = tail;
            for (int i = length - 1; i > index; i--) {
                current = current.prev;
            }
        }
        return current;
    }

    public boolean set(int index, int value) {
        if (head == null || index < 0 || index >= length) {
            return false;
        }
        Node current = get(index);
        if (current != null) {
            current.value = value;
            return true;
        }
        return false;
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

    public Node remove(int index) {
        if (head == null || index < 0 || index >= length) {
            return null;
        } else if (index == 0) {
            return removeFirst();
        } else if (index == length - 1) {
            return removeLast();
        }
        Node removedNode = get(index);
        removedNode.prev.next = removedNode.next;
        removedNode.next.prev = removedNode.prev;
        removedNode.next = null;
        removedNode.prev = null;
        length--;
        return removedNode;
    }

    public boolean isPalindrome() {
        if (head == null || head.next == null) {
            return false;
        }
        Node fromStart = head;
        Node fromEnd = tail;
        for (int i = 0; i < length / 2; i++) {
            if (fromStart.value == fromEnd.value) {
                fromStart = fromStart.next;
                fromEnd = fromEnd.prev;
            } else {
                return false;
            }
        }
        return true;
    }

    public void reverse() {
        if (head == null) {
            return;
        }
        Node current = head;
        head = tail;
        tail = current;
        Node temp;
        for (int i = 0; i < length; i++) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;

        }
    }

    public void partitionList(int x) {
        if (head == null || head.next == null) {
            return;
        }
        Node dummy1 = new Node(0);
        Node dummy2 = new Node(0);
        Node traversal1 = dummy1;
        Node traversal2 = dummy2;
        Node current = head;
        while (current != null) {
            if (current.value < x) {
                // current.next = null;
                traversal1.next = current;
                current.prev = traversal1;
                traversal1 = traversal1.next;
            } else if (current.value >= x) {
                // current.next = null;
                traversal2.next = current;
                current.prev = traversal2;
                traversal2 = traversal2.next;
            }
            current = current.next;
        }
        traversal1.next = dummy2.next;
        traversal2.next = null;
        head = dummy1.next;
        if (dummy2.next != null) {
            dummy2.next.prev = traversal1;
        }
        if (head != null) {
            head.prev = null;
        }
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null || startIndex == endIndex) {
            return;
        }
        Node dummy = new Node(0);
        dummy.next = head;
        head.prev = dummy;
        Node prev = dummy;
        for (int i = 0; i < startIndex; i++) {
            prev = prev.next;
        }
        Node current = prev.next;
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = current.next;
            current.next = nodeToMove.next;
            if (nodeToMove.next != null) {
                nodeToMove.next.prev = current;
            }
            nodeToMove.next = prev.next;
            prev.next.prev = nodeToMove;
            prev.next = nodeToMove;
            nodeToMove.prev = prev;
        }
        head = dummy.next;
        head.prev = null;
    }

    public void swapPairs() {
        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;

        while (head != null && head.next != null) {
            Node firstNode = head;
            Node secondNode = head.next;

            previousNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            secondNode.prev = previousNode;
            firstNode.prev = secondNode;

            if (firstNode.next != null) {
                firstNode.next.prev = firstNode;
            }

            head = firstNode.next;
            previousNode = firstNode;
        }

        head = dummyNode.next;
        if (head != null) {
            head.prev = null;
        }
    }
}
