class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}
class StackSLL {
    Node head = null;
    public void push(int data) {
        Node newNode = new Node(data);

        if(head == null) {
            head = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public  boolean isEmpty() {
        return head == null;
    }

    public int pop() {
        if(isEmpty()) {
            return -1;
        }
        Node top = head;
        head = head.next;
        return top.data;
    }

    public int peek() {
        if(isEmpty()) {
            return -1;
        }
        Node top = head;
        return top.data;
    }
}
public class StackSinglyLinkedList {
    public static void main(String[] args) {
        StackSLL stack = new StackSLL();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        while(!stack.isEmpty()) {
        System.out.println(stack.peek());
        stack.pop();
        }
    }


}
