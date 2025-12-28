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

    public void createCycle(int pos) {
        if(pos < 0) return ;

        Node cycleNode = null;
        Node curr = head;
        int index = 0;

        while(curr.next != null) {
            if(index == pos) cycleNode = curr;
            curr = curr.next;
            index++;
        }
        curr.next = cycleNode;
    }

    public boolean hasCycle() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) return true;
        }
        return false;
    }

    public Node findCycleStart() {
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast) break;
        }
        if(fast == null || fast.next == null) return null;

        slow = head;

        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    public void removeCycle() {
        Node start = findCycleStart();
        if(start == null) return ;

        Node ptr = start;
        while(ptr.next != start) {
            ptr = ptr.next;
        }
        ptr.next = null;
    }
}

public class CycleDetectionPattern {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);
        list.insert(50);

        list.createCycle(2);

        System.out.println("Cycle present? " + list.hasCycle());

        Node start = list.findCycleStart();
        System.out.println("Cycle starts at: " + start.data);

        list.removeCycle();

        System.out.println("Cycle present? " + list.hasCycle());
    }
}