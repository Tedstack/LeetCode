package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class InvalidParentheses {
    public List<String> removeInvalidParentheses(String s) {
        int l=0, r=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') l++;
            if(c==')'){
                if(l==0)
                    r++;
                else
                    l--;
            }
        }
        List<String> result = new ArrayList<>();
        dfs(0,new StringBuilder(), 0, l+r,s,result);
        return result;
    }

    public boolean isValid(String s){
        int l=0;
        for(int i=0;i<s.length();i++){
            char c = s.charAt(i);
            if(c=='(') l++;
            if(c==')'){
                if(l==0)
                    return false;
                else
                    l--;
            }
        }
        return l==0;
    }

    private void dfs(int i, StringBuilder sb, int left, int mis, String s, List<String> res) { // take when possible
        if (i == s.length() && left == 0) { // complete
            res.add(sb.toString());
        } else if (i <s.length() && left >= 0) { // process while valid
            char c = s.charAt(i);
            int  leftChange = c == '(' ? 1 : c == ')' ? -1 : 0;
            sb.append(c);
            dfs(i + 1, sb, left + leftChange, mis, s, res); // take
            sb.deleteCharAt(sb.length() - 1);
            if (mis > 0 && !(sb.length() > 0 && s.charAt(i) == sb.charAt(sb.length() - 1)) && (c == ')' || c == '(')) {
                dfs(i + 1, sb, left, mis - 1, s, res); // skip
            }
        }
    }
}
