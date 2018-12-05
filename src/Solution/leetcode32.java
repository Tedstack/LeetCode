package Solution;

import java.util.Stack;
//TODO
public class leetcode32 {
    public int longestValidParentheses(String s) {
        int count=0;
        Stack<Character> parenthese=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='(')
                parenthese.push(s.charAt(i));
            else{
                if(!parenthese.isEmpty()){
                    char ch=parenthese.pop();
                    count+=2;
                }
            }
        }
        return count;
    }
}
