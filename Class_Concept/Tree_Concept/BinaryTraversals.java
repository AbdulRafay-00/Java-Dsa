package Class_Concept.Tree_Concept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BinaryTraversals {
    
    int itx = -1;
    int levitx = -1;
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

// post order traversal
// <Left, Right, Root>
    public <T> void postOrder(Node<T> root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }



// level order traversal
    public <T> void levelOrder(Node<T> root){
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null); // Use null as a level separator

        while(!queue.isEmpty()){
            Node<T> currnode = queue.poll();
            if(currnode == null){
                System.out.print("\n");
                if (queue.isEmpty()) {
                    return;
                }
                if (!queue.isEmpty()) {
                    queue.add(null);
                    
                }
            }
            else{
                System.out.print(currnode.data + " ");
                if(currnode.left != null){
                    queue.add(currnode.left);
                }
                if(currnode.right != null){
                    queue.add(currnode.right);
                }
            }
        }
    }

}