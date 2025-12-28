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

    public int findKthFromEnd(int k) {
        if(head == null || k <= 0) {
            throw new IllegalArgumentException("Invalid Input");
        }
        Node slow = head;
        Node fast = head;
        for (int i = 0; i < k; i++) {
            if(fast == null) {
                throw new IllegalArgumentException("K is larger than list size");
            }
            fast = fast.next;
        }
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow.data;
    }

    public void removeKthFromEnd(int k) {
        Node dummy = new Node(0);
        dummy.next = head;

        Node slow = dummy;
        Node fast = dummy;
        // Offset Fast Pointer
        for (int i = 0; i < k+1; i++) {
            fast = fast.next;
        }
        // Move together
        while(fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        head = dummy.next;
    }
}

public class TwoPointerOffsetPattern {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.traverse();

        System.out.println("2nd node from end: " + list.findKthFromEnd(2));

        list.removeKthFromEnd(2);
        list.traverse();
    }
}
