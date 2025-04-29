//2. Check Balanced Parentheses
//Write a program to check if a given string has balanced parentheses using a stack. Only use
//loops, not recursion.
import java.util.Stack;


public class Check_Balanced_Parentheses {
    static boolean isBalanced(String exp){
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < exp.length(); i++) {
            char ch=exp.charAt(i);

            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }
            else if(ch == ')' || ch == '}' || ch == ']') {

                if (stack.isEmpty()) {
                    return false;
                }
                char top = stack.pop();
                if (!isMatchingParanthesis(top, ch)) {
                    return false;
                }
            }

        }



        return stack.isEmpty();
    }
static boolean isMatchingParanthesis(Character open, Character close){
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
}



    public static void main(String[] args) {
        String[] testStrings = {
                "{2*[3/(5+4)]}",
                "((()))",
                "{[(])}",
                "(((",
                "([{}])",
                "([)]"
        };

        for (String str : testStrings) {
            System.out.println("Expression: " + str + " --> " +
                    (isBalanced(str) ? "Balanced" : "Not Balanced"));
        }
    }
}
