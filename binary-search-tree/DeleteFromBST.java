
public class DeleteFromBST extends TreeNode{
    public TreeNode DeleteNode(TreeNode root, int key){
        if(root == null){
            return null;
        }
// case 1
        if(root.val < key){
            root.Right = DeleteNode(root.Right, key);
        }else if(root.val > key){
            root.Left = DeleteNode(root.Left, key);
        }
        else if(root.val == key){
// case 1
            if(root .Left == null && root.Right == null){
                return null;
            }
// case 2
            if(root.Left == null){
                return root = root.Right;
            }else if(root.Right == null){
                return root.Left;
            }
// case 3
            if(root.Left != null && root.Right != null){
                TreeNode InorderSuccessor = InorderSuccessor(root.Right);
                root.val = InorderSuccessor.val;
                root.Right = DeleteNode(root.Right, InorderSuccessor.val);
            }

        }
        return root;
    }

TreeNode InorderSuccessor( TreeNode root){
// base  case
        if(root.Left == null){
            return root;
        }
// recursive case
        return InorderSuccessor(root.Left);
    }


    
    public static void inorder(TreeNode root) {
        if (root == null) {
            return;
        }

        inorder(root.Left);
        System.out.println(root.val);

        inorder(root.Right);
    }



    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.Left = new TreeNode(3);
        root.Right = new TreeNode(6);
        root.Left.Left = new TreeNode(2);
        root.Left.Right = new TreeNode(4);
        root.Right.Right = new TreeNode(7);

        System.out.println("Full Tree ");
        inorder(root);
        DeleteFromBST deleteFromBST = new DeleteFromBST();
        deleteFromBST.DeleteNode(root, 3);
        
        System.out.println("Inorder Traversal of the BST delete:");
        inorder(root);
        // inorderTraversal(root);
    }
}
