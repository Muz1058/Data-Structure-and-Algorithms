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

class DoubleLinkedList<T>{
    public void printList(Node<T> head){
        Node current=head;
        System.out.print("\n[");
        while(current!=null){
            System.out.print(current.data+",");
            current=current.next;
        }
        System.out.print("]");
    }
    public void printFromTail(Node<T> tail){
        Node current=tail;
        while(current.prev!=null){
            current=current.prev;
        }
        System.out.print("\n[");
        while(current!=null){
            System.out.print(current.data+",");
            current=current.next;
        }
        System.out.print("]");
    }
    public void printFromRandom(Node<T> random){
        Node<T> current=random;
        while(current.prev!=null){
            current=current.prev;
        }
        System.out.print("\n[");
        while(current!=null){
            System.out.print(current.data+",");
            current=current.next;
        }
        System.out.print("]");

    }
}






public class DoubblyLinkedListTraversing {
    public static void main(String[] args) {
      DoubleLinkedList<Integer> doubleLinkedList=new DoubleLinkedList<>();
        Node<Integer> a = new Node<>(4);
        Node<Integer> b = new Node<> (5);
        Node<Integer> c = new Node<> (6);
        Node<Integer> d = new Node<> (7);

        a.next=b;
        b.prev=a;
        b.next=c;
        c.prev=b;
        c.next=d;
        d.prev=c;

        doubleLinkedList.printList(a);
        doubleLinkedList.printFromTail(d);
        doubleLinkedList.printFromRandom(c);
    }

}
