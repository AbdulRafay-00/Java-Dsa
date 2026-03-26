package Class_Concept.Tree_Concept;

import java.util.ArrayList;
import java.util.Arrays;


public class LongestDiameterTree {
    BinaryTraversals traversals = new BinaryTraversals();

// code is good but the time complexity in o(n2)                                {
    static BinaryTraversals binaryTraversals = new BinaryTraversals();

    int DiameterSubTree(Node node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = countSubTree(node.left);
        int righthight = countSubTree(node.right);
        System.out.println("\n"+"left height is " + leftHeight);
        System.out.println("right height is " + righthight);
        int rootcount = leftHeight + righthight + 1;
        System.out.println("root count is " + rootcount);
        int maxTerm = Math.max(Math.max(leftHeight, righthight), rootcount);

        return maxTerm;
    }

    // count right sub tree
    int RightSideSubTree(Node node) {
        if (node == null) {
            return 0;
        }
        int rightHeight = countSubTree(node.right);
        return rightHeight;
    }

    // Sub tree counter
    int countSubTree(Node node) {
        if (node == null) {
            return 0;
        }
        int subTreeleft = countSubTree(node.left);
        int subTreeright = countSubTree(node.right);
        
        if (subTreeleft > subTreeright) {
            
            System.out.print(node.data + ", ");
            
            return subTreeleft + 1;
        }
        else{
            System.out.print(node.data + ", ");
            return subTreeright + 1;
        }

    }
    //                                                   } 0(n2) why bec we are calculating firse the right then left and then comparing it 


int maxDiameter = 0;

int DiameterSubTreeOptimal(Node node) {
    if (node == null) {
        return 0;
    }

    int leftHeight  = DiameterSubTreeOptimal(node.left);
    int rightHeight = DiameterSubTreeOptimal(node.right);

    System.out.println("\nAt node: " + node.data);
    System.out.println("left height is  " + leftHeight);
    System.out.println("right height is " + rightHeight);

    // Path passing through this node
    int pathThroughNode = leftHeight + rightHeight;
    System.out.println("path through this node = " + pathThroughNode);

    // Update global max
    maxDiameter = Math.max(maxDiameter, pathThroughNode);

    // Return height
    return Math.max(leftHeight, rightHeight) + 1;
}

// code of big o(n) time complexity

    public static void main(String aurg[]){
        

    ArrayList<Integer> eqnodes = new ArrayList<>(Arrays.asList(
    1,
    2,
    9,
    10,
    4, null, null,
    5, null, null,
    3,
    6, null, null,
    7, null, 9
));

    ArrayList<Integer> leftSideTree = new ArrayList<>(Arrays.asList(
    1,        // root
    2,        // 1.left
    9,        // 2.left
    10,       // 9.left
    4, null, null, // 10.left = 4, 4.left = null, 4.right = null
    null,     // 10.right = null
    null      // 9.right = null
    // 2.right = null
    // 1.right = null
));

ArrayList<Integer> LeftDomTree = new ArrayList<>(Arrays.asList(
    1,       // root
    2,       // 1.left
    9, null, null, // 2.left = 9, 9.left=null, 9.right=null
    3,       // 2.right = 3
    null,    // 3.left = null
    4,       // 3.right = 4
    null,    // 4.left = null
    5,       // 4.right = 5
    null, null, // 5.left=null, 5.right=null
    null      // 1.right = null
));

ArrayList<Integer> rightDominatedTree = new ArrayList<>(Arrays.asList(
    1,        // root
    null,     // 1.left = null
    2,
    5,
    null,        // 1.right = 2
    null,     // 2.left = null
    3,        // 2.right = 3
    null,     // 3.left = null
    4,        // 3.right = 4
    null,     // 4.left = null
    5,        // 4.right = 5
    null, null, // 5.left=null, 5.right=null
    null 
));

    LongestDiameterTree longestDiameterTree = new LongestDiameterTree();

        Node node =  binaryTraversals.Createtree(eqnodes);

        int leftSubTree = longestDiameterTree.DiameterSubTreeOptimal(node);
        System.out.println(" max diameter of the tree is " + longestDiameterTree.maxDiameter);
    }

}
