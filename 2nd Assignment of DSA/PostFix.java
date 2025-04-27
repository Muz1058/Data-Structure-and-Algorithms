import java.util.Stack;

public class PostFix {
    public static int evaluate(String exp){
        if (exp==null|| exp.trim().isEmpty()){
            throw new IllegalArgumentException("Expresion must not be null or empty");
        }
        Stack<Integer> stack=new Stack<>();
        String []tokens=exp.trim().split(" ");

        for (String token :tokens){
            if(isNumber(token)){
                stack.push(Integer.parseInt(token));
            }
            else if (isOperator(token)) {
                if(stack.size()<2){
                    throw new IllegalArgumentException("Error ==>> Insufficient Operands");
                }
                int b=stack.pop();
                int a=stack.pop();

                int result=applyOperator(a,b,token);
                stack.push(result);

            }
            else {
                throw new IllegalArgumentException("Error ==>> Invalid token '" + token + "'");

            }

        }

        if(stack.size()!=1){
            throw new IllegalArgumentException("Error ==>> Invalid Expression");
        }
        return stack.pop();
    }


    private static boolean isNumber(String num){
        try{
            Integer.parseInt(num);
            return true;
        }
        catch (NumberFormatException e){
            return false;
        }
    }

    private static boolean isOperator(String op){
        String myOp="+-*/%^";
        return myOp.contains(op)&&op.length()==1;
    }

    private static int applyOperator(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            case "/":
                if (b == 0) {
                    throw new ArithmeticException("Error ==>> Division by zero.");
                }
                return a / b;
            case "%":
                if (b == 0) {
                    throw new ArithmeticException("Error ==>> Modulus by zero.");
                }
                return a % b;
            case "^":
                return (int) Math.pow(a, b);
            default:
                throw new IllegalArgumentException("Unsupported operator: " + operator);
        }
    }





    public static void main(String[] args) {
        System.out.println(evaluate("5 6 + 2 *"));



    }
}
