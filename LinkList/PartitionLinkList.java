package LinkList;

public class PartitionLinkList {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    public static ListNode partition(ListNode head, int x) {

        if (head == null || head.next == null) {
            return head;
        }

        // If head is >= x, find the first node < x
        if (head.val >= x) {

            ListNode prev = head;
            ListNode newHead = head.next;

            while (newHead != null && newHead.val >= x) {
                prev = newHead;
                newHead = newHead.next;
            }

            // No node is smaller than x
            if (newHead == null) {
                return head;
            }

            // Remove newHead from its old position
            prev.next = newHead.next;

            // Put newHead before the old head
            newHead.next = head;

            // newHead becomes the new head
            head = newHead;
        }

        // Now head is < x
        ListNode tem = head;
        ListNode prev = head;
        ListNode tail = head.next;

        while (tail != null) {

            // tail is already in the < x section
            if (tail.val < x && tem.next == tail) {

                tem = tail;
                prev = tail;
                tail = tail.next;
            }

            // tail belongs to the >= x section
            else if (tail.val >= x) {

                prev = tail;
                tail = tail.next;
            }

            // tail is < x but is currently after the >= x section
            else {

                ListNode nextTail = tail.next;

                // Remove tail from its current position
                prev.next = nextTail;

                // Insert tail after tem
                tail.next = tem.next;
                tem.next = tail;

                // tail is now the end of the < x section
                tem = tail;

                // Continue from the original next node
                tail = nextTail;
            }
        }

        return head;
    }

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        int x = 3;

        ListNode result = partition(head, x);

        while (result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }
    }
}