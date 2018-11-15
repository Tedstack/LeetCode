package Solution;

import java.util.ArrayList;
import java.util.List;

public class leetcode22 {
    public List<String> generateParenthesis(int n) {
        List<String> result=new ArrayList<>();
        generateTempPar(n,n,result,"");
        return  result;
    }
    private void generateTempPar(int left,int right,List<String> result,String current){
        if(left>right)
            return;
        if(left==0 && right==0)
            result.add(current);
        if(left>0)
            generateTempPar(left-1,right,result,current+"(");
        if(right>0)
            generateTempPar(left,right-1,result,current+")");
    }
}
