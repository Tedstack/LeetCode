package Solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GroupAna {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result=new ArrayList<>();
        if(strs==null || strs.length==0)
            return result;
        if(strs.length==1){
            List<String> sol=new ArrayList<>();
            sol.add(strs[0]);
            result.add(sol);
            return result;
        }
        for(int i=0;i<strs.length;i++){
            if(!strs[i].equals("")){
                List<String> sol=new ArrayList<>();
                sol.add(strs[i]);
                for(int j=i+1;j<strs.length;j++){
                    if(!strs[j].equals("") && compareTo(strs[i],strs[j])) {
                        sol.add(strs[j]);
                        strs[j]="";
                    }
                }
                result.add(sol);
            }
        }
        return result;
    }
    private boolean compareTo(String s1, String s2){
        if(s1.length()!=s2.length())
            return false;
        char[] t1=s1.toCharArray();
        char[] t2=s2.toCharArray();
        Arrays.sort(t1);
        Arrays.sort(t2);
        for(int i=0;i<t1.length;i++){
            if(t1[i]!=t2[i])
                return false;
        }
        return true;
    }
}
