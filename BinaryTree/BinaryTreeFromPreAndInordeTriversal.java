package BinaryTree;

public class BinaryTreeFromPreAndInordeTriversal {

    static int preIndex = 0;

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        return build(preorder, inorder, 0, inorder.length - 1);
    }

    public static TreeNode build(int[] preorder, int[] inorder,
                                 int left, int right) {

        // No elements in this range
        if (left > right) {
            return null;
        }

        // First element in preorder is the root
        int rootValue = preorder[preIndex++];
        TreeNode root = new TreeNode(rootValue);

        // Find root in inorder
        int rootIndex = left;

        while (inorder[rootIndex] != rootValue) {
            rootIndex++;
        }

        // Build left subtree
        root.left = build(
                preorder,
                inorder,
                left,
                rootIndex - 1
        );

        // Build right subtree
        root.right = build(
                preorder,
                inorder,
                rootIndex + 1,
                right
        );

        return root;
    }
}