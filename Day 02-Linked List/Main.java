
import linkedlist.*;
import linkedlist.LinkedList.Node;

class Main {

    public static void main(String args[]) {
        System.err.println("Radhe Radhe");
        LinkedList myLinkedList = new LinkedList(3);
        myLinkedList.prepend(2);
        myLinkedList.prepend(1);
        myLinkedList.append(4);
        myLinkedList.append(5);
        myLinkedList.removeFirst();
        Node deletedNode = myLinkedList.removeLast();
        System.err.println("DeletedNode: " + deletedNode.value);
        myLinkedList.printList("abc");
        myLinkedList.insert(1, 23);
        myLinkedList.insert(1, 38);
        myLinkedList.insert(0, 49);
        int len = myLinkedList.getLength();
        System.err.println("length: " + len);
        myLinkedList.printList("xyz");
        Node node = myLinkedList.getNode(1); // Fetch the node at a particular index
        System.out.println("Node: " + node.value);
    }
}
