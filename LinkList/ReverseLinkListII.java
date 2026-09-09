package LinkList;

public class ReverseLinkListII {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {

        if (head == null || head.next == null || left == right) {
            return head;
        }

        ListNode prev;
        ListNode mid;
        ListNode next;

        ListNode dummy = null;
        ListNode prevdumm = null;

        int count;

        // Reversal starts from head
        if (left == 1) {

            prev = null;
            mid = head;
            next = head.next;

            prevdumm = head;
            count = 0;

        } else {

            prev = head;
            mid = head.next;
            next = mid.next;

            count = 1;

            // Move to the left position
            while (count + 1 < left) {
                prev = mid;
                mid = next;
                next = next.next;
                count++;
            }

            // Node before reversal
            dummy = prev;

            // Original left node becomes the tail
            prevdumm = mid;
        }

        // Reverse from left to right
        while (true) {

            mid.next = prev;
            prev = mid;

            // We have reversed the right node
            if (count + 1 == right) {
                break;
            }

            mid = next;
            next = next.next;
            count++;
        }

        // Connect the reversed part with the left side
        if (dummy == null) {
            head = prev;
        } else {
            dummy.next = prev;
        }

        // Connect the tail of reversed part
        // with the node after right
        prevdumm.next = next;

        return head;
    }

    // Print linked list
    public static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {
            System.out.print(current.val + " -> ");
            current = current.next;
        }

        System.out.println("null");
    }

    public static void main(String[] args) {

        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.println("Before:");
        printList(head);

        int left = 2;
        int right = 4;

        head = reverseBetween(head, left, right);

        System.out.println("After:");
        printList(head);
    }
}