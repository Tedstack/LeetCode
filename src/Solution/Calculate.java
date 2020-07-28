package Solution;

import java.util.Stack;

public class Calculate {

    /**
     * No parenthese
     * @param s
     * @return
     */
    public int calculateNoP(String s) {
        Stack<Integer> stack = new Stack<>();
        int num=0;
        char preOper='+';
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c==' ') continue;
            if('0'<=c && c<='9')
                num=num*10+c-'0';
            if((!Character.isDigit(c) && c != ' ') || i == s.length() - 1){
                if(preOper == '+')
                    stack.push(num);
                else if(preOper == '-')
                    stack.push(0-num);
                else if(preOper == '*')
                    stack.push(stack.pop() * num);
                else if(preOper == '/')
                    stack.push(stack.pop() / num);
                preOper = c;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public int calculate(String s) {
        return calculateBetween(s,0,s.length()-1);
    }

    public int calculateBetween(String s, int start, int end){
        Stack<Integer> stack = new Stack<>();
        int num=0;
        char preOper='+';
        for(int i=start;i<=end;i++){
            char c = s.charAt(i);
            if(c=='('){
                int index=nextClosing(s,i);
                num = calculateBetween(s,i+1,index);
                i=index;
            }
            if('0'<=c && c<='9')
                num=num*10+c-'0';
            if((!Character.isDigit(c) && c != ' ' && c !='(') || i == end){
                if(preOper == '+')
                    stack.push(num);
                else if(preOper == '-')
                    stack.push(-1*num);
                else if(preOper == '*')
                    stack.push(stack.pop() * num);
                else if(preOper == '/')
                    stack.push(stack.pop() / num);
                preOper = c;
                num = 0;
            }
        }
        int res = 0;
        while(!stack.isEmpty()){
            res += stack.pop();
        }
        return res;
    }

    public int nextClosing(String s, int start){
        int count=0;
        for(int i=start;i<s.length();i++){
            if(s.charAt(i)=='(') count++;
            else if(s.charAt(i)==')') count--;
            if(count==0) return i;
        }
        return -1;
    }
}
