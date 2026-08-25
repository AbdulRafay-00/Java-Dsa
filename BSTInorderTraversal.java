
import java.util.ArrayList;
import java.util.List;

public class BSTInorderTraversal {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static List<Integer> arr = new ArrayList<>();

    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.left);

        arr.add(root.val);

        inorder(root.right);
    }

    public static void main(String[] args) {


        TreeNode root = new TreeNode(4);

        root.left = new TreeNode(2);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);

        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(7);

        inorder(root);

        System.out.println(arr);
    }
}