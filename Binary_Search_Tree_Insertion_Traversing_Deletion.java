class Node {
    int data; // Value of the node
    Node left; // Left child
    Node right; // Right child

    // Constructor to initialize a node with a value
    public Node(int value) {
        this.data = value;
        this.left = null;
        this.right = null;
    }
}

class BST {
    private Node root; // Root of the Binary Search Tree

    // Insert a key into BST
    // Time Complexity: Best/Average - O(log n), Worst - O(n)
    public void insert(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            // Found a spot to insert the new node
            return new Node(key);
        } else if (key < root.data) {
            // Insert into left subtree
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            // Insert into right subtree
            root.right = insertRec(root.right, key);
        } else {
            // Avoid inserting duplicate values
            System.out.println("Duplicate value " + key + " not allowed.");
        }
        return root;
    }

    // Inorder traversal (Left, Root, Right)
    // Time Complexity: O(n)
    public void inorder() {
        inorderMethod(root);
    }

    private void inorderMethod(Node root) {
        if (root != null) {
            inorderMethod(root.left);
            System.out.print(root.data + "-->");
            inorderMethod(root.right);
        }
    }

    // Preorder traversal (Root, Left, Right)
    // Time Complexity: O(n)
    public void preOrder() {
        preOrderMethod(root);
    }

    private void preOrderMethod(Node root) {
        if (root != null) {
            System.out.print(root.data + "-->");
            preOrderMethod(root.left);
            preOrderMethod(root.right);
        }
    }

    // Postorder traversal (Left, Right, Root)
    // Time Complexity: O(n)
    public void postOrder() {
        postOrderMethod(root);
    }

    private void postOrderMethod(Node root) {
        if (root != null) {
            postOrderMethod(root.left);
            postOrderMethod(root.right);
            System.out.print(root.data + "-->");
        }
    }

    // Search for a value and show its inorder predecessor and successor
    // Time Complexity: Best/Average - O(log n), Worst - O(n)


    public boolean search(int value) {
        return searchBST(root, value);
    }

    private boolean searchBST(Node root, int key) {
        if (root == null) return false;

        if (root.data == key) {
            // Node found
            return true;
        } else if (key < root.data) {
            return searchBST(root.left, key);
        } else {
            return searchBST(root.right, key);
        }
    }

    // Find the rightmost node in the left subtree (Inorder Predecessor)
    // Time Complexity: O(h) where h is tree height
    private Node inOrderPredecessor(Node node) {
        node=node.left;
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    // Find the leftmost node in the right subtree (Inorder Successor)
    // Time Complexity: O(h) where h is tree height
    private Node inOrderSuccessor(Node node) {
        node=node.right;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Delete a node from BST
    // Time Complexity: Best/Average - O(log n), Worst - O(n)
    public void deleteNode(int value) {
        if (!search(value)) {
            System.out.println("Value " + value + " not found. No deletion performed.");
            return;
        }
        root = deletion(root, value);
    }

    private Node deletion(Node node, int key) {
        if (node == null) return null;

        if (key < node.data) {
            node.left = deletion(node.left, key);
        } else if (key > node.data) {
            node.right = deletion(node.right, key);
        } else {
            // Node to be deleted found
            if (node.left == null) return node.right;
            if (node.right == null) return node.left;

            // Node with two children: Replace with inorder successor
            Node successor = inOrderSuccessor(node);
            node.data = successor.data;
            node.right = deletion(node.right, successor.data);
        }
        return node;
    }

    // Find maximum value in BST
    // Time Complexity: Best - O(1), Average/Worst - O(h)
    public int maximum() {
        if (root == null) throw new RuntimeException("Tree is empty");
        Node myNode = root;
        while (myNode.right != null) {
            myNode = myNode.right;
        }
        return myNode.data;
    }

    // Find minimum value in BST
    // Time Complexity: Best - O(1), Average/Worst - O(h)
    public int minimum() {
        if (root == null) throw new RuntimeException("Tree is empty");
        Node myNode = root;
        while (myNode.left != null) {
            myNode = myNode.left;
        }
        return myNode.data;
    }

    // Optional: Height of the BST
    // Time Complexity: O(n)
    public int height() {
        return height(root);
    }

    private int height(Node node) {
        if (node == null) return -1; // Height of empty tree is -1
        return 1 + Math.max(height(node.left), height(node.right));
    }
}


public class Binary_Search_Tree_Insertion_Traversing_Deletion {
    public static void main(String[] args) {
        BST bst = new BST();

        int[] value = {5, 4, 6, 7, 2, 3, 11, 15, 10};
        for (int i : value) {
            bst.insert(i);
        }

        System.out.println("In Order");
        bst.inorder();

        System.out.println("\n\nPre Order");
        bst.preOrder();

        System.out.println("\n\nPost Order");
        bst.postOrder();

        System.out.println("\n\nSearching");
        System.out.println("Search 11: " + bst.search(11));

        bst.deleteNode(6);
        System.out.println("\n\nafter deletion of 6");
        bst.inorder();

        System.out.println("\n\nMax = " + bst.maximum());
        System.out.println("Min = " + bst.minimum());
    }
}
