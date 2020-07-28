package Solution;
/*Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.*/
public class leetcode31 {
    public void nextPermutation(int[] nums) {
        int index=nums.length-1;
        while(index>0){
            if(nums[index-1]<nums[index])
                break;
            index--;
        }
        if(index==0){
            reverseArray(nums,0,nums.length-1);
        } else {
            int target = index - 1;
            reverseArray(nums,index,nums.length-1);
            for(int i = index;i<nums.length;i++){
                if(nums[i]>nums[target]){
                    int temp = nums[i];
                    nums[i] = nums[target];
                    nums[target] = temp;
                    break;
                }
            }
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
