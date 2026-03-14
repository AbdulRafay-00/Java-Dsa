
/*important concept of binary tree
 *can contain only two children per node
 *use heap memory to store node just as link list
*/
package Class_Concept.Tree_Concept;

import java.util.ArrayList;

public class BinaryTree {
    public static void main(String[] args) {
        System.out.println("Binary Tree Concept");
        ArrayList<Integer> nodes = new ArrayList<>();
        // nodes.add(1);
        // nodes.add(2);
        // nodes.add(4);
        // nodes.add(5);
        // nodes.add(6);
        // nodes.add(7);
        // nodes.add(8);
        // nodes.add(9);
        // nodes.add(10);
        nodes.add(1);
        nodes.add(2);
        nodes.add(null);
        nodes.add(null);
        nodes.add(3);
        nodes.add(4);
        nodes.add(null);
        BinaryTraversals traversals = new BinaryTraversals();
        Node root = traversals.Createtree(nodes);
        System.out.println("root node is " + root.data);

        traversals.levelOrder(root);
    }
}
