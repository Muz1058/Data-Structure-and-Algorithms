class Node<T>{
    T data;
    Node<T> next;
    Node<T> prev;//previous Node

    public Node(T data){
        this.data=data;
        this.next=null;
        this.prev=null;
    }
}
class DoublyLInkedList<T>{

    public void removeFirst(Node<T> node){
        if(node==null){
            System.out.println("Linked List Doesn't exist");
            return;
        }
        while(node.prev!=null){
            node=node.prev;
        }
        if (node.next == null) {
            System.out.println("Only one element exists, can't remove.");
            return;
        }
        Node<T> initial=node;
        node=node.next;
        node.prev=null;
        initial.next=null;


    }
}

public class DoublyLinkedList_Deletion {
    public static void main(String[] args) {

    }
}
