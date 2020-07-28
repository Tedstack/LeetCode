package SlidingWindow;

import java.util.HashMap;

public class MinWindows {
    public String minWindow(String s, String t) {
        String result=s+ " ";
        char[] tempList = s.toCharArray();
        char[] solList = t.toCharArray();
        int start = 0;
        int end = 0;
        HashMap<Character, Integer> map=new HashMap<>();
        for(int i=0;i<solList.length;i++){
            if(map.containsKey(solList[i]))
                map.put(solList[i],map.get(solList[i])+1);
            else
                map.put(solList[i],1);
        }
        int count = t.length();
        while(end<s.length()){
            if(map.containsKey(s.charAt(end))){
                if(map.get(s.charAt(end))>0)
                    count--;
                map.put(s.charAt(end), map.get(s.charAt(end))-1);
            }
            end++;
            if(count==0){
                while(start<end && count==0){
                    if(map.containsKey(tempList[start])){
                        int flag=map.get(tempList[start]);
                        if(flag>=0){
                            count++;
                            result=result.length()>end-start ? s.substring(start,end) : result;
                        }
                        map.put(tempList[start],flag+1);
                    }
                    start++;
                }
            }
        }
        return result.length() == s.length()+1? "": result;
    }
}
