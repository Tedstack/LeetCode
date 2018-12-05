package Solution;
//includeing leetcode 33 and 35
public class leetcode33 {
    public int search(int[] nums, int target) {
        int start=0,end=nums.length-1;
        while(start<=end){
          int middle=(start+end)/2;
          if(nums[middle]==target)
              return middle;
          else if(nums[middle]>=nums[start]){
              if(nums[middle]>target && target>=nums[start]){
                  end=middle-1;
              }else {
                  start=middle+1;
              }
          }else{
              if(nums[end]>=target && nums[middle]<target)
                  start=middle+1;
              else
                  end=middle-1;
          }
        }
        return -1;
    }
    public int searchInsert(int[] nums, int target) {
        int start=0,end=nums.length-1,position=-1;
        while(start<=end){
            int middle=(start+end)/2;
            if(nums[middle]==target)
                return middle;
            else if(nums[middle]>target){
                if(middle==0)
                    return 0;
                else if(nums[middle-1]<target)
                    return middle;
                else
                    end=middle-1;
            }else{
                if(middle==nums.length-1)
                    return nums.length;
                else if(nums[middle+1]>target)
                    return middle+1;
                else
                    start=middle+1;
            }
        }
        return 0;
    }
}
