package DepthFirstSearch;

import java.util.*;

public class AlienDictionary {
    public String alienOrder(String[] words) {
        String result="";
        int[] indegree = new int[26];
        Map<Character, Set<Character>> g =new HashMap<>();
        bulidGraph(g,words,indegree);
        return bfs(g,indegree);
    }

    public void bulidGraph(Map<Character, Set<Character>> g, String[] words, int[] indegree){
        for(String word: words){
            for(char c: word.toCharArray()){
                g.putIfAbsent(c, new HashSet<>());
            }
        }
        for(int i=1;i<words.length;i++){
            String firstWord = words[i-1];
            String secondWord = words[i];
            int len = Math.min(firstWord.length(),secondWord.length());
            for(int j=0;j<len;j++){
                if(firstWord.charAt(j)!=secondWord.charAt(j)){
                    char out = firstWord.charAt(j);
                    char in = secondWord.charAt(j);
                    if(!g.get(out).contains(in)){
                        indegree[secondWord.charAt(j)-'a']++;
                        g.get(out).add(in);
                    }
                    break;
                }
            }
        }
    }

    public String bfs(Map<Character, Set<Character>> g, int[] indegree){
        StringBuilder sb = new StringBuilder();
        Queue<Character> q = new LinkedList<>();
        for (char c : g.keySet()){
            if(indegree[c-'a']==0){
                sb.append(c);
                q.offer(c);
            }
        }
        while(!q.isEmpty()){
            char out = q.poll();
            if(g.get(out) == null || g.get(out).size()==0) continue;
            for(char in : g.get(out)){
                indegree[in-'a']--;
                if(indegree[in-'a']==0) {
                    sb.append(in);
                    q.offer(in);
                }
            }
        }
        return sb.length() == g.size() ? sb.toString() : "";
    }
}
