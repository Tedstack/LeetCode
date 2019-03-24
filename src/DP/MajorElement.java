package DP;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MajorElement {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(!map.containsKey(nums[i]))
                map.put(nums[i],1);
            else{
                map.put(nums[i],map.get(nums[i]));
            }
        }
        int result=nums[0];
        for(int key:map.keySet()){
            if(map.get(result)<map.get(key))
                result=key;
        }
        return result;
    }
    //摩尔投票算法
    public List<Integer> majorityElementThanThird(int[] nums) {
        List<Integer> list = new ArrayList<>();
        if(nums.length==0)
           return list;
        int n1=nums[0],count1=1;
        int n2=nums[0],count2=1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==n1)
                count1++;
            else if(nums[i]==n2)
                count2++;
            else if(count1==0) {
                n1 = nums[i];
                count1++;
            }else if(count2==0) {
                n2 = nums[i];
                count2++;
            }
            else {
                count1--;
                count2--;
            }
        }
        count1=0;
        count2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==n1)
                count1++;
            if(nums[i]==n2)
                count2++;
        }
        if(count1>nums.length/3)
            list.add(n1);
        if(count2>nums.length/3 && n1!=n2)
            list.add(n2);
        return list;
    }
}
