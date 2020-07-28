package DS;

import java.util.*;

public class FirstUnique {

    Queue<Integer> queue;
    Map<Integer,Boolean> indexMap = new HashMap<>();
    List<Integer> unique = new LinkedList<>();

    public FirstUnique(int[] nums) {
        queue=new LinkedList<>();
        for(int i : nums){
            queue.offer(i);
            if(!indexMap.containsKey(i)){
                indexMap.put(i,true);
                unique.add(i);
            }else{
                unique.remove((Integer)i);
            }
        }
    }

    public int showFirstUnique() {
        if(unique.size()>0)
            return unique.get(0);
        else
            return -1;
    }

    public void add(int value) {
        queue.offer(value);
        if(!indexMap.containsKey(value)){
            indexMap.put(value,true);
            unique.add(value);
        }else{
            unique.remove((Integer)value);
        }
    }
}