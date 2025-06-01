
import doubly_linked_list.*;

class Main {

    public static void main(String args[]) {
        DoublyLinkedList myLinkedList = new DoublyLinkedList(2);
        myLinkedList.prepend(1);
        myLinkedList.prepend(0);
        myLinkedList.append(3);
        myLinkedList.append(5);
        myLinkedList.set(2, 10);
        System.out.println(myLinkedList.length);
        boolean isInserted = myLinkedList.insert(4, 4);
        myLinkedList.printList();
        System.out.println(isInserted);
    }

}
