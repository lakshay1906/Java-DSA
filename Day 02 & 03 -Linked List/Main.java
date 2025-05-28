
import linkedlist.*;

class Main {

    public static void main(String args[]) {
        System.err.println("Radhe Radhe");
        LinkedList myLinkedList = new LinkedList(1);
        // myLinkedList.prepend(2);
        // myLinkedList.prepend(1);
        // myLinkedList.append(0);
        // myLinkedList.append(0);
        // myLinkedList.append(0);
        myLinkedList.append(3);
        myLinkedList.append(5);
        myLinkedList.append(2);
        myLinkedList.append(10);
        myLinkedList.append(11);
        myLinkedList.append(12);
        // myLinkedList.removeFirst();
        // Node deletedNode = myLinkedList.removeLast();
        // System.err.println("DeletedNode: " + deletedNode.value);
        myLinkedList.printList("abc");
        // myLinkedList.insert(1, 23);
        // myLinkedList.insert(1, 38);
        // myLinkedList.insert(0, 49);
        // int len = myLinkedList.getLength();
        // System.err.println("length: " + len);
        // myLinkedList.printList("xyz");
        // Node node = myLinkedList.getNode(1); // Fetch the node at a particular index
        // System.out.println("Node: " + node.value);
        // Node removedNode = myLinkedList.remove(2);
        // System.err.println("Removed Node: " + removedNode.value);
        // myLinkedList.reverse();
        // Node node = myLinkedList.findMiddleNode();
        // System.err.println("Node: " + node.value);
        // Node node = myLinkedList.findKthFromEnd(9);
        // System.err.println("Node: " + node);
        // myLinkedList.removeDuplicates();
        // int num = myLinkedList.binaryToDecimal();
        // System.err.println("num: "+ num);
        // myLinkedList.partitionList(5);
        // myLinkedList.reverseBetween(1, 4);
        myLinkedList.swapPairs();
        myLinkedList.printList("xyz");
    }
}
