package Graph;

/**
 * Created by Surya Vamsi on 18-Jun-16.
 */
public class LinkedList {
    Node head;
    Node tail;

    static class Node {
        int data;
        Node next;

        public Node(int d) {
            data = d;
            next = null;
        }
    }

    public static void main(String[] args) {
        LinkedList llist = new LinkedList();
        llist.head = new Node(1);
        llist.head.next = new Node(2);
        llist.head.next.next = new Node(3);
        llist.head.next.next.next = new Node(4);
        llist.head.next.next.next.next = new Node(5);
        LinkedListUtils utils = new LinkedListUtils();
        System.out.println(
                utils.nthElementFromLast(llist, 1).data);
        utils.nthElementByRecursion(llist.head,5);

    }

    static void swap(LinkedList ll, int d1, int d2) {
        Node head = ll.head;
        Node pos1 = null;
        Node pos2 = null;
        if (head == null) return;
        while (head.next != null) {
            if (pos1 != null && pos2 != null) break;
            if (head.data == d1) {

                if (pos1 == null) pos1 = head;
                else pos2 = head;
                head = head.next;
                continue;
            } else if (head.data == d2) {
                if (pos1 == null) pos1 = head;
                else pos2 = head;
                head = head.next;
                continue;
            }
            head = head.next;
            if (head == null) break;
        }
        if (pos1 == null || pos2 == null) return;


    }

    static int length(LinkedList ll) {
        int count = 0;
        if (ll.head == null) return 0;
        Node start = ll.head;
        while (start.next != null) {
            count++;
            start = start.next;
        }
        return count + 1;

    }

    static void delete(LinkedList ll, int d) {
        Node temp = ll.head;
        Node prev = null;
        if (temp != null && temp.data == d) {
            ll.head = temp.next;
            return;
        }
        while (temp != null && temp.data != d) {
            prev = temp;
            temp = temp.next;
        }
        if (temp == null) return;
        if (temp.data == d) {
            prev.next = temp.next;
            temp = null;
        }
    }

    static void printList(LinkedList list) {
        Node temp = list.head;
        while (temp != null) {
            System.out.print(temp.data + " ");

            temp = temp.next;
        }
        System.out.println();
    }

    static void insert_end(LinkedList ll, int data) {
        Node temp = new Node(data);
        if (ll.head == null) {
            ll.head = new Node(data);
            ll.tail = ll.head;
        } else {
            Node start = ll.head;

            while (start.next != null) {
                start = start.next;
            }
            start.next = temp;
            ll.tail = temp;
        }
    }

    static void insert(LinkedList ll, int data, Node prev_node) {
        Node temp = new Node(data);
        Node third = prev_node.next;
        prev_node.next = temp;
        temp.next = third;

    }

    static void push(LinkedList ll, int data) {
        Node temp = new Node(data);
        Node prev = ll.head;
        ll.head = temp;
        ll.head.next = prev;
    }
}
