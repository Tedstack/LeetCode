package Solution;

import java.util.Stack;

public class Polish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(int i = 0;i<tokens.length;i++){
            if(tokens[i].equals("+")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1+num2);
            }else if(tokens[i].equals("-")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2-num1);
            }else if(tokens[i].equals("*")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num1*num2);
            }else if(tokens[i].equals("/")){
                int num1 = stack.pop();
                int num2 = stack.pop();
                stack.push(num2/num1);
            } else{
                stack.push(Integer.valueOf(tokens[i]));
            }
        }
        return stack.peek();
    }
}
