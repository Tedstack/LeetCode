package Solution;
/*
Find First and Last Position of Element in Sorted Array
*/
public class leetcode34 {
    public int[] searchRange(int[] nums, int target) {
        int[] result=new int[]{-1,-1};
        if(nums.length==0)
            return result;
        int start_left=0,end_left=nums.length-1,start_right=0,end_right=nums.length-1;
        while(start_left<=end_left){
            int mid_left=(start_left+end_left)/2;
            if(nums[mid_left]==target){
                if(mid_left==0 || nums[mid_left-1]<nums[mid_left]) {
                    result[0] = mid_left;
                    break;
                }
                else
                    end_left=mid_left-1;
            }else if(nums[mid_left]>target)
                end_left=mid_left-1;
            else
                start_left=mid_left+1;
        }
        while(start_right<=end_right){
            int mid_right=(start_right+end_right)/2;
            if(nums[mid_right]==target){
                if(mid_right==nums.length-1 || nums[mid_right+1]>nums[mid_right]) {
                    result[1] = mid_right;
                    break;
                }
                else
                    start_right=mid_right+1;
            }else if(nums[mid_right]>target)
                end_right=mid_right-1;
            else
                start_right=mid_right+1;
        }
        return result;
    }
}
