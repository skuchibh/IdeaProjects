package Graph;

import lib.utils.OutputWriter;

/**
 * Created by Surya Vamsi on 28-Jun-16.
 */
public class LinkedListUtils {
    static OutputWriter out;
    static int cnt = 0;

    public boolean isCircular(LinkedList list) {
        out = new OutputWriter(System.out);
        LinkedList.Node slower = list.head;
        LinkedList.Node faster = list.head.next;

        while (true) {
            if (slower == null || faster == null) return false;
            if (faster == slower || faster.next == slower) return true;
            slower = slower.next;
            faster = faster.next.next;
        }
    }

    public void reverseList(LinkedList list){}

    public LinkedList.Node nthElementFromLast(LinkedList list, int n) {
        LinkedList.Node tail = list.head;
        LinkedList.Node head = list.head;
        if (n < 1 || list.head == null) return null;
        for (int i = 0; i < n - 1; i++) {
            if (head == null) return null;
            else head = head.next;
        }
        while (head.next != null) {
            head = head.next;
            tail = tail.next;
        }
        return tail;
    }

    public void nthElementByRecursion(LinkedList.Node node, int n) {
        if (node == null) return;
        nthElementByRecursion(node.next, n);
        if (++cnt == n) {
            System.out.println(node.data + " is the nth element from the last");
        }
    }
}
