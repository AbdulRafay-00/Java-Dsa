public class ConvertLinkListtoBST {

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

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

        // Sorted linked list:
        // 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ConvertLinkListtoBST solution = new ConvertLinkListtoBST();

        TreeNode root = solution.sortedListToBST(head);

        System.out.println("Inorder traversal of BST:");
        inorder(root);
    }

    public TreeNode sortedListToBST(ListNode head) {
        return recursiveCall(head, null);
    }

    TreeNode recursiveCall(ListNode head, ListNode tail) {

        // Base case: empty range
        if (head == tail) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;

        while (fast != tail && fast.next != tail) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;

        TreeNode root = new TreeNode(mid.val);

        // Left: from head up to (but not including) mid
        root.left = recursiveCall(head, mid);

        // Right: from mid.next up to tail
        root.right = recursiveCall(mid.next, tail);

        return root;
    }

    static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }
}
