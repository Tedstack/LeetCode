package Solution;

import java.util.Stack;

/*Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.*/
public class leetcode20 {
    public boolean isValid(String s) {
        boolean valid=true;
        Stack<Character> Parentheses=new Stack<Character>();
        for(int i=0;i<s.length();i++){
            char par=s.charAt(i);
            if(par=='(' || par=='{' || par=='[')
                Parentheses.push(par);
            else{
                if(Parentheses.isEmpty())
                    return false;
                char top=Parentheses.pop();
                if(!isMatch(top,par))
                    return false;
            }
        }
        if(Parentheses.isEmpty())
            return true;
        else
            return false;
    }
    public boolean isMatch(char a,char b){
        if((a=='(' && b==')') || (a=='[' && b==']') ||(a=='{' && b=='}'))
            return true;
        else
            return false;
    }
}
