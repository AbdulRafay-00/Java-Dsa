package LinkList;

public class RotatedList {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) return head;

        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }

        k = k % len;
        if (k == 0) return head;

        int cut = len - k;

        ListNode prev = head;
        ListNode curr = head.next;
        ListNode newHead = null;
        int idx = 1; // curr's current index

        while (true) {
            if (idx == cut) {
                newHead = curr;
                prev.next = null;
            }

            if (curr.next == null) {
                curr.next = head;
                head = newHead;
                break;
            }

            prev = curr;
            curr = curr.next;
            idx++;
        }

        return head;
    }

    // helper to build a list from an array
    private static ListNode buildList(int[] arr) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        for (int v : arr) {
            tail.next = new ListNode(v);
            tail = tail.next;
        }
        return dummy.next;
    }

    // helper to print a list
    private static void printList(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        while (head != null) {
            sb.append(head.val);
            if (head.next != null) sb.append(", ");
            head = head.next;
        }
        sb.append("]");
        System.out.println(sb);
    }

    public static void main(String[] args) {
        ListNode head = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode result = rotateRight(head, 2);
        printList(result); // expected [4, 5, 1, 2, 3]
    }
}