
class Node {
    int key;
    Node left, right;

    Node(int item) {
        key = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a new key
    Node insert(Node node, int key) {
        if (node == null) {
            return new Node(key);
        }
        if (key < node.key) {
            node.left = insert(node.left, key);
        } else if (key > node.key) {
            node.right = insert(node.right, key);
        }
        return node;
    }

    void insert(int key) {
        root = insert(root, key);
    }

    // Search for a key
    boolean search(Node node, int key) {
        if (node == null) {
            return false;
        }
        if (node.key == key) {
            return true;
        }
        return key < node.key ? search(node.left, key) : search(node.right, key);
    }

    boolean search(int key) {
        return search(root, key);
    }
}

public class Main {
    public static void main(String[] args) {
        BinarySearchTree bst = new BinarySearchTree();

        bst.insert(50);
        bst.insert(30);
        bst.insert(70);
        bst.insert(20);
        bst.insert(40);
        bst.insert(60);
        bst.insert(80);

        int key = 40;
        if (bst.search(key)) {
            System.out.println(key + " found in the BST.");
        } else {
            System.out.println(key + " not found in the BST.");
        }

        key = 90;
        if (bst.search(key)) {
            System.out.println(key + " found in the BST.");
        } else {
            System.out.println(key + " not found in the BST.");
        }
    }
}
