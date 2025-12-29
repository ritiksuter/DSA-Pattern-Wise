class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class CircularLinkedList {
    Node head;

    CircularLinkedList() {
        head = null;
    }

    public void insert(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }

        Node curr = head;
        while (curr.next != head) {
            curr = curr.next;
        }
        curr.next = newNode;
        newNode.next = head;
    }

    public void traverse() {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }
        Node curr = head;

        do {
            System.out.print(curr.data + " ");
            curr = curr.next;
        } while (curr != head);

        System.out.println();
    }

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }

        newNode.next = head;
        tail.next = newNode;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            newNode.next = head;
            return;
        }
        Node tail = head;
        while (tail.next != head) {
            tail = tail.next;
        }
        tail.next = newNode;
        newNode.next = head;
    }

    public void delete(int key) {
        if (head == null) {
            System.out.println("List is empty");
            return;
        }

        if (head.data == key && head.next == head) {
            head = null;
            return;
        }

        // Delete Head
        if (head.data == key) {
            Node tail = head;
            while (tail.next != head) {
                tail = tail.next;
            }
            tail.next = head.next;
            head = head.next;
            return;
        }

        // Delete non-head node ->
        Node prev = head;
        Node curr = head.next;

        while (curr != head) {
            if (curr.data == key) {
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Key not found !");
    }

    public Node[] split() {
        Node[] result = new Node[2];

        // Empty list
        if (head == null)
            return result;

        // Only one node
        if (head.next == head) {
            result[0] = head;
            result[1] = null;
            return result;
        }

        Node slow = head;
        Node fast = head;

        // Find Middle
        while (fast.next != head && fast.next.next != head) {
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast.next.next == head) {
            fast = fast.next;
        }

        Node head1 = head;
        Node head2 = slow.next;

        slow.next = head1;
        fast.next = head2;

        result[0] = head1;
        result[1] = head2;

        return result;
    }
}

public class TraversalPattern {
    public static void main(String[] args) {

    }
}