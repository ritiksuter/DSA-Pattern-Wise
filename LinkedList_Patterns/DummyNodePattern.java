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

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    public void traverse() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    public void delete(int value) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null) {
            if (curr.data == value) {
                prev.next = curr.next;
                break;
            }
            prev = curr;
            curr = curr.next;
        }
        head = dummy.next;
    }

    public void insertAtBeginning(int data) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node newNode = new Node(data);
        newNode.next = dummy.next;
        dummy.next = newNode;

        head = dummy.next;
    }
}

public class DummyNodePattern {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        list.traverse();

        list.delete(10); // delete head
        list.traverse();

        list.insertAtBeginning(99);
        list.traverse();
    }
}