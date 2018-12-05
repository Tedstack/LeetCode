package Solution;
/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.*/
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        int index=nums.length-1,temp=0;
        while(index>0){
            if(nums[index-1]<nums[index])
                break;
            index--;
        }
        if(index==0){
            reverseArray(nums,0,nums.length-1);
        }else{
            int target=index-1;
            for(;index<nums.length;index++){
                if(nums[target]>=nums[index])
                    break;
            }
            temp=nums[target];
            nums[target]=nums[index-1];
            nums[index-1]=temp;
            reverseArray(nums,target+1,nums.length-1);
        }
    }
    private void reverseArray(int[] nums,int start,int end){
        while(start<end){
            int temp=nums[start];
            nums[start]=nums[end];
            nums[end]=temp;
            start++;
            end--;
        }
    }
}
