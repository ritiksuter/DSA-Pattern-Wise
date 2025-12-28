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

    public boolean isPalindrome() {
        if(head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        Node secondHalf = reverse(slow.next);

        Node p1 = head;
        Node p2 = secondHalf;

        boolean result = true;
        while(p2 != null) {
            if(p1.data != p2.data) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        slow.next = reverse(secondHalf);

        return result;
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

public class PalindromeLinkedListPattern {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(2);
        list.insert(1);

        list.traverse();

        System.out.println("Is Palindrome? " + list.isPalindrome());

        list.traverse();
    }
}