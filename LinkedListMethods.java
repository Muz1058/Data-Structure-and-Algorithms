class Node<T>{
    T data;
    Node<T> next;

    Node(T data){
        this.data=data;
        next=null;
    }
}
class LinkedList<T>{
     Node<T> head;
    public void addFirst(T data)
    {
        Node<T> newNode=new Node<>(data);
        if (head==null)
        {
            head=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }
    // Add Last
    public void addLast(T data)
    {
        Node<T> newNode=new Node<>(data);
        Node<T> current=head;
        if (head==null)
        {
            head=newNode;
            return;
        }
        while (current.next!=null)
        {
            current=current.next;
        }
        current.next=newNode;
    }
     public void insertAt(int index,T data){
         Node<T> newNode=new Node<T>(data);

         if(index==0){
             newNode.next=head;
             head=newNode;
             return;
         }
         Node<T> current=head;
         if(current == null){
             System.out.println("Position Out of bound");
             return;
         }

         for (int i=0;i<index-1&& current!=null;i++){
             current= current.next;
         }

         newNode.next=current.next;
         current.next=newNode;
     }
     public void insertAfter(Node<T> prevNode, T data){
         if(prevNode==null){
             System.out.println("Previous Node Cannot be Null");
             return;
         }
         Node<T> newNode=new Node<>(data);
         newNode.next=prevNode.next;
         prevNode.next=newNode;
     }

     public void insertBefore(Node<T> nextNode,T data){
         if(head==null|| nextNode==null){
             System.out.println("List is empty or Next Node is Null");
             return;
         }
         Node<T> newNode = new Node<>(data);
         // If inserting before the head
         if (head == nextNode) {
             newNode.next = head;
             head = newNode;
             return;
         }

         Node<T> current =head;
         while (current.next!= null && current.next!= nextNode)
         {
             current=current.next;
         }
         // If nextNode is not found
         if (current.next == null) {
             System.out.println("The given node is not present in the list");
             return;
         }
         newNode.next=nextNode;
         current.next=newNode;


     }

    public void display(){
         Node<T> current=head;
         while (current !=null){
             System.out.print(current.data+" ");
             current=current.next;
         }
    }

}


public class LinkedListMethods {
    public static void main(String[] args) {
    

    }
}
