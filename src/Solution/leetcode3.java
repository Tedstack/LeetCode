package Solution;
import java.util.HashMap;

public class leetcode3 {
    public int lengthOfLongestSubstring(String s) {
        if(s.length()==0)
            return 0;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        int max=0;
        for(int i=0,j=0,length=s.length();i<length;i++){
            if(map.containsKey(s.charAt(i)))
                j=Math.max(j,map.get(s.charAt(i))+1);
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}
