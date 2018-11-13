package Solution;
import java.util.*;
public class leetcode18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result=new ArrayList<>();
        if(nums.length<4)
            return result;
        Arrays.sort(nums);
        for(int i=0,length=nums.length;i<length-3;i++){
            if(i>0 && nums[i]==nums[i-1]) continue;
            for(int j=i+1;j<length-2;j++){
                if(j>i+1 && nums[j]==nums[j-1]) continue;
                int start=j+1,end=length-1;
                while(start<end){
                    int sum=nums[i]+nums[j]+nums[start]+nums[end];
                    if(sum==target){
                        result.add(Arrays.asList(nums[i],nums[j],nums[start],nums[end]));
                        while(start<end && nums[start]==nums[start+1]) start++;
                        while(start<end && nums[end]==nums[end-1]) end--;
                        start++;
                        end--;
                    }else if(sum<target){
                        start++;
                    }else{
                        end--;
                    }
                }
            }
        }
        return result;
    }
}
