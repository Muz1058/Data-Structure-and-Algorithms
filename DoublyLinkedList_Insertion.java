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
class DoublyLinkedList<T>{
    public void insertFirst(T data,Node<T> node){
        Node<T> newNode=new Node<>(data);
        Node<T> head=node;
        if(node.prev==null){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
        else {
            while(head.prev!=null){
                head=head.prev;
            }
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }
    }
    public void insertLast(T data ,Node<T> node){
        Node<T> newNode=new Node<>(data);
        Node<T> tail=node;
        while(tail.next !=null){
            tail=tail.next;
        }
        tail.next=newNode;
        newNode.prev=tail;
    }
    public void insertAt(T data,int index,Node<T> node){
        Node<T> newNode=new Node<>(data);
        if(index<0){
            System.out.println("Index must be greater then O");
            return;
        }
        if(index==0){
            newNode.next=node;
            node.prev=newNode;
        }
        else {
            while (node.prev!=null){
                node=node.prev;
            } //now node is pointing at head
            int i=0;
            while(node.next!=null && i<index-1){
                node=node.next;
                i++;
            }
            newNode.next=node.next;
            newNode.prev=node;
            if(node.next!=null){
                node.next.prev=newNode;
            }
            node.next=newNode;
        }

    }
    public void printList(Node<T> head){
        Node<T> current=head;
        System.out.print("[");
        while(current!=null){
            System.out.print(current.data+",");
            current=current.next;
        }
        System.out.print("]\n");
    }
}

public class DoublyLinkedList_Insertion {
    public static void main(String[] args) {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

        // Step 1: Create initial nodes 20 -> 30
        Node<Integer> node1 = new Node<>(20);
        Node<Integer> node2 = new Node<>(30);
        node1.next = node2;
        node2.prev = node1;

        System.out.println("Initial List:");
        list.printList(node1); // [20, 30]

        // Step 2: insertFirst (10)
        list.insertFirst(10, node1); // Pass any node from list
        System.out.println("\nAfter insertFirst(10):");
        list.printList(node1); // [10, 20, 30]

        // Step 3: insertLast (40)
        list.insertLast(40, node2); // Pass any node from list
        System.out.println("\nAfter insertLast(40):");
        list.printList(node1); // [10, 20, 30, 40]

        // Step 4: insertAt index 2 → insert 25
        list.insertAt(25, 2, node2);
        System.out.println("\nAfter insertAt(25, index 2):");
        list.printList(node1); // [10, 20, 25, 30, 40]

        // Step 5: insertAt index 0 → insert 5
        list.insertAt(5, 0, node2);
        System.out.println("\nAfter insertAt(5, index 0):");
        list.printList(node1); // [5, 10, 20, 25, 30, 40]

        // Step 6: insertAt index 6 → insert 50 (end)
        list.insertAt(50, 6, node2);
        System.out.println("\nAfter insertAt(50, index 6):");
        list.printList(node1); // [5, 10, 20, 25, 30, 40, 50]
    }
}

