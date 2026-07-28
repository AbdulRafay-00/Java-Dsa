package Array_con;

public class BalancedBSTFromArray {

    // TreeNode class
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Main function
    public static TreeNode sortedArrayToBST(int[] nums) {
        return buildTree(nums, 0, nums.length - 1);
    }

    // Recursive function
    public static TreeNode buildTree(int[] nums, int left, int right) {

        // Base case
        if (left > right) {
            return null;
        }

        // Find middle element
        int mid = left + (right - left) / 2;

        // Create root node
        TreeNode root = new TreeNode(nums[mid]);

        // Build left subtree
        root.left = buildTree(nums, left, mid - 1);

        // Build right subtree
        root.right = buildTree(nums, mid + 1, right);

        return root;
    }

    // Inorder traversal to verify BST
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        int[] nums = {-10, -3, 0, 5, 9};

        TreeNode root = sortedArrayToBST(nums);

        System.out.println("Inorder Traversal:");
        inorder(root);
    }
}