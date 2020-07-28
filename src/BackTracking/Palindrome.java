package BackTracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Palindrome {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        find(result, new ArrayList<String>(), s);
        return result;
    }

    public boolean checkPartition(String s){
        if(s.length()==1) return true;
        int start = 0, end = s.length()-1;
        while(start<end){
            if(s.charAt(start) != s.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }

    public void find(List<List<String>> result, List<String> solution, String s){
        if(s.length()==0){
            result.add(new ArrayList<>(solution));
            return;
        }
        for(int i=1;i<=s.length();i++){
            String sub = s.substring(0,i);
            if(checkPartition(sub)){
                solution.add(sub);
                find(result, solution, s.substring(i));
                solution.remove(solution.size()-1);
            }
        }
    }
}
