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

    public static LinkedList mergeSortedLists(LinkedList l1, LinkedList l2) {
        Node dummy = new Node(0);
        Node tail = dummy;
        Node p1 = l1.head;
        Node p2 = l2.head;

        while(p1 != null && p2 != null) {
            if(p1.data <= p2.data) {
                tail.next = p1;
                p1 = p1.next;
            }
            else {
                tail.next = p2;
                p2 = p2.next;
            }
            tail = tail.next;
        }
        if(p1 != null) tail.next = p1;
        if(p2 != null) tail.next = p2;

        LinkedList result = new LinkedList();
        result.head = dummy.next;
        return result;
    }
}

public class MergerTwoSortedLL {
    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.insert(1);
        list1.insert(3);
        list1.insert(5);

        LinkedList list2 = new LinkedList();
        list2.insert(2);
        list2.insert(4);
        list2.insert(6);

        LinkedList merged = LinkedList.mergeSortedLists(list1, list2);

        merged.traverse();
    }
}