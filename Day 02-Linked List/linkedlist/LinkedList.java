package linkedlist;

import java.util.HashSet;
import java.util.Set;

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

    // Remove a node at a particular index
    public Node remove(int index) {
        if (index < 0 || index >= length) {
            return null;
        } else if (index == 0) {
            Node temp = head;
            removeFirst();
            return temp;
        } else {
            Node temp = head;
            Node pre = head;
            for (int i = 0; i < length; i++) {
                if (i == index) {
                    Node temp2 = temp;
                    pre.next = temp.next;
                    temp.next = null;
                    length--;
                    return temp2;
                }
                pre = temp;
                temp = temp.next;
            }
            return null;
        }
    }

    public void reverse() {
        if (head == null) {
            System.err.println("Linked list is empty");
            return;
        }
        Node temp = head;
        head = tail;
        tail = temp;
        Node after;
        Node before = null;
        for (int i = 0; i < length; i++) {
            after = temp.next;
            temp.next = before;
            before = temp;
            temp = after;
        }
    }

    public Node findMiddleNode() {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
        return slow;
    }

    public Node findKthFromEnd(int k) {
        if (head == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;
        for (int i = 1; i < k; i++) {
            fast = fast.next;
            if (fast == null) {
                return null;
            }
        }
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // Using nexted loops instead of using hashSet.
    // This method is not efficient as hashSet because nexted loops have time complexity O(n^m) where m is the number of nexted loops. In this case the time complexity is O(n^2).
    // public void removeDuplicates() {
    //     Node current = head;
    //     Node runner;
    //     while (current != null) {
    //         runner = current;
    //         while (runner.next != null) {
    //             if (runner.next.value == current.value) {
    //                 System.err.println("runner: " + runner.next.value + ", current: " + current.value);
    //                 runner.next = runner.next.next;
    //                 length--;
    //             } else {
    //                 runner = runner.next;
    //             }
    //         }
    //         current = current.next;
    //     }
    // }

    // Using hashSet
    // This method is more efficient on the basis of time complexity which is O(n) in this case.
    public void removeDuplicates() {
        Set<Integer> values = new HashSet<>();
        Node pre = null;
        Node current = head;

        while (current != null) {
            if (values.contains(current.value)) {
                pre.next = current.next;
                length--;
            } else {
                values.add(current.value);
                pre = current;
            }
            current = current.next;
        }
    }

    public int binaryToDecimal() {
        int decimalValue = 0;
        Node current = head;
        while (current != null) {
            decimalValue *= 2;
            decimalValue += current.value;
            current = current.next;
        }
        return decimalValue;
    }

    public void partitionList(int n) {
        if (head == null) {
            return;
        }
        Node current = head;
        Node dummy1 = new Node(0); // for smaller value nodes
        Node dummy2 = new Node(0); // for larger value nodes
        Node prev1 = dummy1;
        Node prev2 = dummy2;

        while (current != null) {
            if (current.value < n) {
                // Insert the node in dummy1
                prev1.next = current;
                prev1 = prev1.next;
            } else {
                // Insert the node in dummy2
                prev2.next = current;
                prev2 = prev2.next;
            }
            current = current.next;
        }

        prev1.next = dummy2.next;
        head = dummy1.next;
        prev2.next = null;
    }

    public void reverseBetween(int startIndex, int endIndex) {
        if (head == null) {
            return;
        }

        Node dummyNode = new Node(0);
        dummyNode.next = head;
        Node previousNode = dummyNode;
        for (int i = 0; i < startIndex; i++) {
            previousNode = previousNode.next;
        }
        Node currentNode = previousNode.next;
        for (int i = 0; i < endIndex - startIndex; i++) {
            Node nodeToMove = currentNode.next;
            currentNode.next = nodeToMove.next;
            nodeToMove.next = previousNode.next;
            previousNode.next = nodeToMove;
        }

        head = dummyNode.next;
    }

    public void swapPairs() {
        Node dummy = new Node(0);
        dummy.next = head;

        Node previous = dummy;
        Node first = head;

        while (first != null && first.next != null) {
            Node second = first.next;
            previous.next = second;
            first.next = second.next;
            second.next = first;
            previous = first;
            first = first.next;
        }
        head = dummy.next;
    }

}
