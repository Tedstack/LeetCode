package DP;

public class houseRob {
    public int rob(int[] nums) {
        return DP(nums,0,nums.length-1);
    }
    public int robCircle(int[] nums) {
        if(nums.length==0)
            return 0;
        if(nums.length==1)
            return nums[0];
        if(nums.length==2)
            return Math.max(nums[0],nums[1]);
        return Math.max(DP(nums,0,nums.length-2),DP(nums,1,nums.length-1));
    }
    private int DP(int[] nums,int begin,int end){
        int[] Rob=new int[end-begin+1];
        int[] unRob=new int[end-begin+1];
        Rob[0]=nums[begin];
        unRob[0]=0;
        for(int i=1;i<end-begin+1;i++){
            Rob[i]=unRob[i-1]+nums[begin+i];
            unRob[i]=Math.max(Rob[i-1],unRob[i-1]);
        }
        return Math.max(Rob[end-begin],unRob[end-begin]);
    }
}
