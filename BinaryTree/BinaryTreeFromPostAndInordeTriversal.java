package BinaryTree;

public class BinaryTreeFromPostAndInordeTriversal {

    static int postIndex;

    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        postIndex = postorder.length - 1;
        return build(inorder, postorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] inorder, int[] postorder,
                                 int left, int right) {

        // No elements in this range
        if (left > right) {
            return null;
        }

        // Last element in postorder is the root
        int rootValue = postorder[postIndex--];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = left;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Build right subtree
        root.right = build(
                inorder,
                postorder,
                rootIndex + 1,
                right
        );

        // Build left subtree
        root.left = build(
                inorder,
                postorder,
                left,
                rootIndex - 1
        );

        return root;
    }
}