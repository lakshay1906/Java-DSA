
import queue.*;
import dsa_stack.*;
import queue.Queue.*;

class Main {

    public static void main(String[] args) {
        System.out.println("Radhe Radhe");
        // For stack
        // Stack newStack = new Stack(10);
        // newStack.push(9);
        // newStack.getHeight();
        // newStack.printStack();
        // newStack.pop();
        // newStack.getHeight();
        // newStack.push(8);
        // newStack.printStack();

        // For Queue
        Queue newQueue = new Queue(1);
        newQueue.enqueue(2);
        newQueue.printQueue();
        newQueue.dequeue();
        newQueue.printQueue();
        Node last = newQueue.getLast();
        System.out.println("last: " + last.getValue());
    }
}
