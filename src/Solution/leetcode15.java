package Solution;
import java.util.*;
/*
Given an array nums of n integers, are there elements a, b, c
in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.*/
public class leetcode15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result=new HashSet<>();
        List<Integer> used=new ArrayList<>();
        for(int i=0,length=nums.length;i<length;i++){
            if(used.contains(nums[i]))
                continue;
            used.add(nums[i]);
            int target=0-nums[i];
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int j=i+1;j<length;j++){
                if(map.containsKey(nums[j])) {
                    List<Integer> sol = new ArrayList<>();
                    sol.add(nums[i]);
                    sol.add(map.get(nums[j]));
                    sol.add(nums[j]);
                    result.add(sol);
                }
                map.put(target-nums[j],nums[j]);
            }
        }
        return new ArrayList<>(result);
    }
}
