class Node{
    int data,height;
    Node left,right;

    public Node(int data){
        this.data=data;
        height=1;
        left=null;
        right=null;

    }

}

class AVL{
    Node node;
    public void insert(int data){

    }

    Node insertNode(int data,Node node) {
        if (node == null) return new Node(data);

        else if (data < node.data) {
            node.left = insertNode(data, node.left);
        } else if (data > node.data) {
            node.right = insertNode(data, node.right);
        } else return node;

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        int balance = getBalance(node);
        if (balance > 1 && getBalance(node.left) >= 0)
            return rotateRight(node);
        if (balance > 1 && getBalance(node.left) < 0) {
            node.left = rotateLeft(node.left);
            return rotateRight(node);
        }
        if (balance < -1 && getBalance(node.right) <= 0)
            return rotateLeft(node);
        if (balance < -1 && getBalance(node.right) > 0) {
            node.right = rotateRight(node.right);
            return rotateLeft(node);
        }
        return node;

    }


    int height(Node n){
        if(n==null) return 0;

        return n.height;
    }
    int getBalance(Node n){
        if(n==null) return 0;

        return height(n.left)-height(n.right);
    }

    Node rotateRight(Node a){
        Node x=a.left;
        Node temp=x.right;//null
        x.right=a;
        a.left=temp;

        a.height=Math.max(height(a.left),height(a.right))+1;
        x.height=Math.max(height(x.left),height(x.right))+1;

        return x;
    }

    Node rotateLeft(Node a){ //a=A
        Node x=a.right;  //x=b
        Node temp=x.left; // temp=null

        a.left=x;   //a.left=B
        x.right=temp;//x.right


        a.height=Math.max(height(a.left),height(a.right))+1;
        x.height=Math.max(height(x.left),height(x.right))+1;

        return a;
    }
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // (task 3)
    void postOrder(Node node) {
        if (node != null) {
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data + " ");
        }
    }

    // (task 4)
    int findMin() {
        if (node == null) return -1;
        Node curr = node;
        while (curr.left != null)
            curr = curr.left;
        return curr.data;
    }

    // (task 4)
    int findMax() {
        if (node == null) return -1;
        Node curr = node;
        while (curr.right != null)
            curr = curr.right;
        return curr.data;
    }

    // (task 5)
    int treeHeight() {
        return height(node);
    }

    // (task 6)
    int countNodes(Node node) {
        if (node == null)
            return 0;
        return 1 + countNodes(node.left) + countNodes(node.right);
    }
    // (task 6)
    int countLeafNodes(Node node) {
        if (node == null)
            return 0;
        if (node.left == null && node.right == null)
            return 1;
        return countLeafNodes(node.left) + countLeafNodes(node.right);
    }

    // (task 6)
    int countInternalNodes(Node node) {
        if (node == null || (node.left == null && node.right == null))
            return 0;
        return 1 + countInternalNodes(node.left) + countInternalNodes(node.right);
    }

}











public class Main {
    public static void main(String[] args) {
        System.out.println("Hy");
    }
}
