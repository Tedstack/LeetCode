package DP;

public class MaxSubarray {
    public int maxSum(int[] nums) {
        if(nums==null)
            return 0;
        int localMax=nums[0];
        int globalMax=nums[0];
        for(int i=1;i<nums.length;i++){
            localMax=Math.max(localMax+nums[i],nums[i]);
            globalMax=Math.max(globalMax,localMax);
        }
        return globalMax;
    }
    public int maxProduct(int[] nums) {
        if(nums==null)
            return 0;
        int localMax=nums[0];
        int localMin=nums[0];
        int globalMax=nums[0];
        for(int i=1;i<nums.length;i++){
            int max_copy = localMax;
            localMax=Math.max(Math.max(localMax*nums[i],nums[i]),nums[i]*localMin);
            localMin=Math.min(Math.min(max_copy*nums[i],nums[i]),nums[i]*localMin);
            globalMax=Math.max(localMax,globalMax);
        }
        return globalMax;
    }
}
