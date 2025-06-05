
import doubly_linked_list.*;

class Main {

    public static void main(String args[]) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList(3);
        myLinkedList.append(8);
        myLinkedList.append(5);
        myLinkedList.append(10);
        myLinkedList.append(2);
        myLinkedList.append(1);
        myLinkedList.append(7);
        // myLinkedList.set(2, 10);
        // System.out.println(myLinkedList.length);
        // boolean isInserted = myLinkedList.insert(4, 4);
        // System.out.println(isInserted);
        myLinkedList.printList();
        // myLinkedList.reverse();
        // myLinkedList.partitionList(4);
        // myLinkedList.reverseBetween(1, 4);
        myLinkedList.swapPairs();
        myLinkedList.printList();

        // boolean result = myLinkedList.isPalindrome();
        // System.out.println("result: " + result);
    }

}
