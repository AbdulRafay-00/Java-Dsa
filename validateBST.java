import java.util.ArrayList;
import java.util.List;

public class validateBST {

    List<Integer> arr = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        return inorder(root);
    }

    public boolean inorder(TreeNode root) {

        // Base case
        if (root == null) {
            return true;
        }

        // LEFT
        if (!inorder(root.left)) {
            return false;
        }

        // ROOT
        if (!arr.isEmpty()) {
            int previous = arr.get(arr.size() - 1);

            if (previous >= root.val) {
                return false;
            }
        }

        arr.add(root.val);

        // RIGHT
        if (!inorder(root.right)) {
            return false;
        }

        return true;
    }

    // Binary Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {

        /*
                 5
                / \
               3   7
              / \ / \
             2  4 6  8

            Inorder:
            2 → 3 → 4 → 5 → 6 → 7 → 8

            Valid BST
        */

        TreeNode root = new TreeNode(
            5,
            new TreeNode(
                3,
                new TreeNode(2),
                new TreeNode(4)
            ),
            new TreeNode(
                7,
                new TreeNode(6),
                new TreeNode(8)
            )
        );

        validateBST solution = new validateBST();

        boolean result = solution.isValidBST(root);

        System.out.println("Is valid BST? " + result);
    }
}