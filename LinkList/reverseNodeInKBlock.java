package LinkList;

public class reverseNodeInKBlock {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;

        int count = 0;
        ListNode tem = head;

        while (tem != null) {
            count++;
            tem = tem.next;
        }

        int block = count / k;

        ListNode curr = head;
        ListNode prev = null;
        ListNode temp = curr;
        ListNode tail = null;

        int kcount = 0;
        boolean firstGroup = true;

        while (block > 0) {
            ListNode next = curr.next;

            curr.next = prev;
            prev = curr;
            curr = next;

            kcount++;

            if (kcount == k) {
                if (firstGroup) {
                    head = prev;
                    firstGroup = false;
                } else {
                    tail.next = prev;
                }

                temp.next = curr;
                tail = temp;
                temp = curr;

                block--;
                prev = null;
                kcount = 0;
            }
        }

        return head;
    }

    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        ListNode result = reverseKGroup(head, k);

        printList(result);
    }
}