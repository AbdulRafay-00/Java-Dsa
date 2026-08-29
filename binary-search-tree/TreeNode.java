// package binary-search-tree;

public class TreeNode{
    int val;
    TreeNode Left;
    TreeNode Right;
    TreeNode(){};
    TreeNode(int val){
        this.val = val;
    };
    TreeNode(int val, TreeNode Left, TreeNode Right){
        this.val = val;
        this.Left = Left;
        this.Right = Right;
    };
}



//  public class BSTImplementation {

//     public static void main(String[] args) {
//         TreeNode root = new TreeNode(5);
//         root.Left = new TreeNode(3);
//         root.Right = new TreeNode(6);
//         root.Left.Left = new TreeNode(2);
//         root.Left.Right = new TreeNode(4);
//         root.Right.Right = new TreeNode(7);

//         System.out.println("Inorder Traversal of the BST:");
//         // inorderTraversal(root);
//     }
    
// }



