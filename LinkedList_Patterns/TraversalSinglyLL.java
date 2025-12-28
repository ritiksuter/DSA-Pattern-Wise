class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null) {
            current = current.next;
        }
        current.next = newNode;
    }

    public void traverse() {
        if(head == null) {
            System.out.println("Linked List is Empty!");
            return;
        }
        Node current = head;

        while(current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("Null");
    }
}

public class TraversalSinglyLL {
    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.insert(10);
        ll.insert(20);
        ll.insert(30);
        ll.insert(40);
        ll.insert(50);
        ll.traverse();
    }
}