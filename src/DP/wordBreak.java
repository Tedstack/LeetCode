package DP;

import java.util.*;

public class wordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int end=0;end<=s.length();end++){
            for(int start=0;start<end;start++){
                if(dp[start] && wordDict.contains(s.substring(start,end))){
                    dp[end] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }

    //Time limited
    public List<String> wordBreakII(String s, List<String> wordDict) {
        List<String> result = new ArrayList<>();
        boolean[] dp = new boolean[s.length()+1];
        dp[0]=true;
        dfs(result, s, wordDict, 0, dp);
        return result;
    }

    public void dfs(List<String> result, String s, List<String> wordDict, int start, boolean[] dp){
        if(dp[s.length()]){
            String resultString="";
            int lastIndex=0;
            for(int i=1;i<dp.length;i++){
                if(dp[i]) {
                    resultString += s.substring(lastIndex, i) + " ";
                    lastIndex = i;
                }
            }
            resultString = resultString.trim();
            result.add(resultString);
            return;
        }
        for(int i=start;i<=s.length();i++){
            if(dp[start] && wordDict.contains(s.substring(start,i))){
                dp[i]=true;
                dfs(result, s, wordDict, i, dp);
                dp[i]=false;
            }
        }
    }

    public List<String> wordBreak3(String s, List<String> wordDict) {
        List<String> result = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        HashMap<String, List<String>> used = new HashMap<>();
        for(String str:wordDict)
            set.add(str);
        result = helper(s,set,used);
        return result;
    }

    public List<String> helper(String s, HashSet<String> set, HashMap<String, List<String>> used){
        if(used.containsKey(s))
            return used.get(s);
        if(s.length()==0) return null;
        List<String> res = new LinkedList<>();
        for(int i=1;i<=s.length();i++){
            String sub = s.substring(0,i);
            List<String> part = null;
            if(set.contains(sub)){
                part = helper(s.substring(i), set, used);
                if(part==null)
                    res.add(sub);
                else{
                    for(String str: part) {
                        res.add(sub + " " + str);
                    }
                }
            }
        }
        used.put(s, res);
        return res;
    }
}
