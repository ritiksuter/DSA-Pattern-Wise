class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

class DoublyLinkedList {
    Node head;
    Node tail;

    public void insertAtBeginning(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.prev = newNode;
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;
    }

    public void insertAtPosition(int data, int pos) {
        if (pos <= 0) {
            System.out.println("Invalid Position");
            return;
        }
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        Node curr = head;
        int count = 1;

        while (curr != null && count < pos - 1) {
            curr = curr.next;
            count++;
        }
        if (curr == null) {
            System.out.println("Position out of Range!");
            return;
        }
        Node newNode = new Node(data);
        newNode.next = curr.next;
        newNode.prev = curr;

        if (curr.next != null) {
            curr.next.prev = newNode;
        } else
            tail = newNode;

        curr.next = newNode;
    }

    public void deleteFromBeginning() {
        if (head == null)
            return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        head = head.next;
        head.prev = null;
    }

    public void deleteFromEnd() {
        if (tail == null)
            return;
        if (head == tail) {
            head = tail = null;
            return;
        }
        tail = tail.prev;
        tail.next = null;
    }

    public void deleteByValue(int key) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == key) {
                if (curr == head) {
                    deleteFromBeginning();
                } else if (curr == tail)
                    deleteFromEnd();
                else {
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                return;
            }
            curr = curr.next;
        }
        System.out.println("Value not found");
    }

    public void forwardTraversal() {
        Node curr = head;

        while(curr != null) {
            System.out.print(curr.data + "<->");
            curr = curr.next;
        }
        System.out.println();
    }

    public void backwardTraversal() {
        Node curr = tail;
        while(curr != null) {
            System.out.print(curr.data + "<->");
            curr = curr.prev;
        }
        System.out.println();
    }

    public boolean search(int key) {
        Node curr = head;

        while(curr != null) {
            if(curr.data == key) return true;
            curr = curr.next;
        }
        return false;
    }

    public int length() {
        int count = 0;
        Node curr = head;

        while(curr != null) {
            count++;
            curr = curr.next;
        }
        return count;
    }

    public void reverse() {
        Node curr = head;
        Node temp = null;

        while(curr != null) {
            temp = curr.prev;
            curr.prev = curr.next;
            curr.next = temp;
            curr = curr.prev;
        }
        if(temp != null) {
            head = temp.prev;
        }
    }
}

public class AllDLLOperations {
    public static void main(String[] args) {

    }
}
