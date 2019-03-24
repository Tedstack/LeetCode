package DP;

public class jumpGame {
    public int jump(int[] nums) {
        int ret = 0, canReach = 0, R = -1;

        for(int i=0, l = nums.length; i<l; i++){
            if(canReach >= l-1)
                break;
            if(i+nums[i] > canReach){
                if(i > R){
                    R = canReach;
                    ret++;
                }
                canReach = i+nums[i];
            }
        }
        return ret;
    }
}
