package Class_Concept.Tree_Concept;

import java.util.ArrayList;

public class BinaryTraversals {
    
    int itx = -1;
    public <T> Node<T> Createtree (ArrayList<T> Nodes) {
        
        itx++;
        if (itx >= Nodes.size()) {
            return null;
        }
        if (Nodes.get(itx) == null) {
            return null; }
        Node<T> newNode = new Node<>(Nodes.get(itx));
        newNode.left = Createtree(Nodes);

        newNode.right = Createtree(Nodes);
        return newNode;
    }


// pre order traversal
// <Root, Left, Right>
    public <T> void preOrder(Node<T> root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

// in order traversal
// <Left, Root, Right>
    public <T> void inOrder (Node<T> root){

        if(root == null){
            return;
        }

        inOrder(root.left);
        System.out.println(root.data + " ");
        inOrder(root.right);
    }

}
