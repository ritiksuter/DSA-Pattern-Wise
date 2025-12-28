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

    public void reverseIterative() {
        Node prev = null;
        Node curr = head;

        while(curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        head = prev;
    }

    public void reverseRecursive() {
        head = reverseRec(head);
    }

    private Node reverseRec(Node node) {
        if(node == null || node.next == null) return node;

        Node newHead = reverseRec(node.next);
        node.next.next = node;
        node.next = null;

        return newHead;
    }
}

public class ReverseLinkedList {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.print("Original: ");
        list.traverse();

        // list.reverseIterative();
        // System.out.print("Iterative Reverse: ");
        // list.traverse();

        list.reverseRecursive();
        System.out.print("Recursive Reverse: ");
        list.traverse();
    }
}
