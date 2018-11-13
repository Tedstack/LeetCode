package Solution;

import java.util.*;

public class leetcode17 {
    public List<String> letterCombinations(String digits) {
        HashMap<Character,char[]> map=new HashMap<Character, char[]>();
        map.put('2',new char[]{'a','b','c'});
        map.put('3',new char[]{'d','e','f'});
        map.put('4',new char[]{'g','h','i'});
        map.put('5',new char[]{'j','k','l'});
        map.put('6',new char[]{'m','n','o'});
        map.put('7',new char[]{'p','q','r','s'});
        map.put('8',new char[]{'t','u','v'});
        map.put('9',new char[]{'w','x','y','z'});
        List<String> res=new ArrayList<>();
        Queue<String> queue=new LinkedList<String>();
        queue.add("");
        getChar2(digits,queue,map);
        return res;
    }
    //DFS
    public void getChar(String cur,int index,String digits,List<String> res,HashMap<Character,char[]> map){
        if(index==digits.length())
            res.add(cur);
        else{
            char dig=digits.charAt(index);
            if(map.containsKey(dig)){
                for(char ch:map.get(dig)){
                    getChar(cur+ch,index+1,digits,res,map);
                }
            }
        }
    }
    //BFS
    public void getChar2(String digits, Queue<String> queue,HashMap<Character,char[]> map){
        int queueSize=queue.size();
        for(int i=0;i<digits.length();i++){
            char dig=digits.charAt(i);
            for(int j=0;j<queueSize;j++){
                String temp=queue.poll();
                for(char ch :map.get(dig))
                    queue.add(temp+ch);
            }
            queueSize=queue.size();
        }
    }
}
