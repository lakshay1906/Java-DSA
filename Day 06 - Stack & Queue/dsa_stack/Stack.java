package dsa_stack;

public class Stack {

    private Node top;
    private int height;

    class Node {

        Node next;
        int value;

        Node(int value) {
            this.value = value;
        }
    }

    public Stack(int value) {
        Node newNode = new Node(value);
        top = newNode;
        height = 1;
    }

    public void printStack() {
        Node temp = top;
        while (temp != null) {
            System.out.print(temp.value + " <= ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public Node getTop() {
        return top;
    }

    public void getHeight() {
        System.out.println(height);
    }

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        height++;
    }

    public Node pop() {
        if (top == null) {
            return null;
        }
        Node removedNode = top;
        top = top.next;
        removedNode.next = null;
        height--;
        return removedNode;
    }
}
