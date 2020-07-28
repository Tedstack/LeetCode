package Array;

import java.util.HashMap;
import java.util.Map;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        Map<Integer,Boolean> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i]))
                map.put(nums[i],false);
            else
                map.put(nums[i],true);
        }
        for(Integer i:map.keySet()){
            if(map.get(i))
                return i;
        }
        return 0;
    }
}
