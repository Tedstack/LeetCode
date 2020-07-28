package SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringConcatenationAllWords {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(s==null || s.length()==0 || words==null || words.length==0)
            return res;
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0;i<words.length;i++) {
            if (map.containsKey(words[i]))
                map.put(words[i], map.get(words[i]) + 1);
            else
                map.put(words[i], 1);
        }
        int wordLength=words[0].length();
        for(int i=0;i<=wordLength;i++){
            HashMap<String,Integer> curMap=new HashMap<>();
            int count=0;
            int left=i;
            for(int j=i;j<=s.length()-wordLength;j+=wordLength){
                String str=s.substring(j,j+wordLength);
                if(map.containsKey(str)){
                    if(curMap.containsKey(str))
                        curMap.put(str,curMap.get(str)+1);
                    else
                        curMap.put(str,1);
                    if(curMap.get(str)<=map.get(str))
                        count++;
                    else{
                        while(curMap.get(str)>map.get(str)){
                            String temp = s.substring(left,left+wordLength);
                            if(curMap.containsKey(temp)){
                                curMap.put(temp,curMap.get(temp)-1);
                                if(curMap.get(temp)<map.get(temp))
                                    count--;
                            }
                            left+=wordLength;
                        }
                    }
                    if(count==words.length){
                        res.add(left);
                        String temp = s.substring(left,left+wordLength);
                        curMap.put(temp,curMap.get(temp)-1);
                        count--;
                        left+=wordLength;
                    }
                }else{
                    curMap.clear();
                    count=0;
                    left=j+wordLength;
                }
            }
        }
        return res;
    }
}
