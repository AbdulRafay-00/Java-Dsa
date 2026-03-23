package Class_Concept.Tree_Concept;
import java.util.ArrayList;
import java.util.Arrays;

import Class_Concept.Tree_Concept.BinaryTraversals;
public class SubTreeOfTree {
    
    int LongestSide (Node node){
        if (node == null) {
            return 0;
        }
        System.out.print(node.data + " ");
        int leftHeight = LongestSide(node.left);
        int rightHeight = LongestSide(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

// count Left Sub Tree
    int LeftSideSubTree(Node node){
        if (node == null) {
            return 0;
        }
        int leftHeight = countSubTree(node.left);
        return leftHeight;
    }

// count right sub tree
    int RightSideSubTree(Node node){
        if (node == null) {
            return 0;
        }
        int rightHeight = countSubTree(node.right);
        return rightHeight;
    }
// Sub tree counter
    int countSubTree(Node node){
        if (node == null) {
            return 0;
        }
        System.out.print(node.data +", " );
        int SubTreeleft = countSubTree(node.left);
        int SubTreeright = countSubTree(node.right);
        return SubTreeleft + SubTreeright + 1;

    }
    

    public static void main (String [] args){
        BinaryTraversals traversals = new BinaryTraversals();

        ArrayList<Integer> nodes = new ArrayList<>();
        // nodes.add(1);
        // nodes.add(2);
        nodes.add(4);
        nodes.add(5);
        nodes.add(6);
        nodes.add(7);
        nodes.add(8);
        nodes.add(9);
        nodes.add(10);
        nodes.add(1);
        nodes.add(2);
        nodes.add(null);
        // nodes.add(null);
        nodes.add(3);
        nodes.add(4);
        nodes.add(null);


    ArrayList<Integer> eqnodes = new ArrayList<>(Arrays.asList(
    1,
    2,
    4, null, null,
    5, null, null,
    3,
    6, null, null,
    7, null, 9
));

        Node node =  traversals.Createtree(eqnodes);

        int leftSubTree = new SubTreeOfTree().LeftSideSubTree(node);
        System.out.println("Left side of tree is " + leftSubTree);

        // int ans = new LongestSideOfTree().LongestSide(node);
        // System.out.println("Longest side of tree is " + ans);
        
        
    }
    
}
