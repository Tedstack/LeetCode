package Solution;
import java.util.HashMap;
import java.util.Map;

public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s==null || s.length()==0)
            return 0;
        Map<Character,Integer> map=new HashMap<>();
        int maxLength=0,j=0;
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),i);
                j=i;
            }else{
                map.put(s.charAt(i),i);
                maxLength=Math.max(maxLength,i-j+1);
            }
        }
        return maxLength;
    }
}
