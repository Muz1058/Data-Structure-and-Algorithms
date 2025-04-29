//3. Sort a Stack Using Another Stack
//Given a stack, sort it in ascending order using only one additional stack. No recursion is
//allowed.

import java.util.Stack;



public class Sort_Stack_Using_Another_Stack {
    static void sortStack(Stack<Integer> org){
        Stack<Integer> sortedStack=new Stack<>();

        while (!org.isEmpty()){
            int temp=org.pop();

            while (!sortedStack.isEmpty()&&sortedStack.peek()>temp){
                org.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        while (!sortedStack.isEmpty()) {
            org.push(sortedStack.pop());
        }

    }
    static void printStack(Stack<Integer> stack) {
        System.out.println("Stack (top to bottom):");

        for (int i = stack.size() - 1; i >= 0; i--) {
            System.out.print(stack.get(i)+"  ");
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(34);
        stack.push(3);
        stack.push(31);
        stack.push(98);
        stack.push(92);
        stack.push(23);

        System.out.println("Original Stack:");
        printStack(stack);

        sortStack(stack);

        System.out.println("\nSorted Stack:");
        printStack(stack);
    }
}
