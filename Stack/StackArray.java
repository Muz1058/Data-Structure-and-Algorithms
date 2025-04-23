class StackUsingArray{
    int capacity=5,top=-1;
    int []arr=new int[capacity];

    public void push(int value){
        if(top>=capacity-1){
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top]=value;
    }
    public int pop(){
        if(top==-1){
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top--];

    }
    public int peek(){
        if(top==-1){
            System.out.println("Stack underflow");
            return -1;
        }
        return arr[top];
    }
    public void printStack(){
        if(top==-1){
            System.out.println("Stack underflow");
            return ;
        }
        else {
            int i=0;
            while (i<=top){
                System.out.print(arr[i]+" ");
                i++;
            }

        }
        System.out.println();
    }
}


public class StackArray {
    public static void main(String[] args) {
        StackUsingArray stack = new StackUsingArray();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.printStack(); // Output: 10 20 30
        System.out.println("Peek: " + stack.peek()); // Output: 30

        System.out.println("Popped: " + stack.pop()); // Output: 30
        stack.printStack(); // Output: 10 20

        stack.push(40);
        stack.push(50);
        stack.push(60); // Will trigger overflow
        stack.printStack();

    }
}
