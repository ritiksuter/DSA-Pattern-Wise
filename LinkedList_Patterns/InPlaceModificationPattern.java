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

    public void reorderList() {
        if(head == null || head.next == null) return;

        Node slow = head;
        Node fast = head;

        while(fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = reverse(slow.next);
        slow.next = null;

        Node first = head;

        while(second != null) {
            Node t1 = first.next;
            Node t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }

    public Node reverse(Node node) {
        Node prev = null;
        Node curr = node;

        while(curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}

public class InPlaceModificationPattern {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.insert(5);

        list.traverse();

        list.reorderList();

        list.traverse();
    }
}