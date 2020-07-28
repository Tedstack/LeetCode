package Array;

public class KthLargestElement {
    public int findKthLargest(int[] nums, int k) {
        int index=nums.length-k;
        int begin=0, end=nums.length-1;
        while(begin<end){
            int mid = quickSortHandler(nums,begin,end);
            if(mid == index)
                return nums[mid];
            else if(mid>index){
                end = mid -1;
            } else {
                begin = mid+1;
            }
        }
        return nums[begin];
    }

    public int quickSortHandler(int[] nums,int begin,int end){
        int left=begin;
        for(int i=begin+1;i<=end;i++){
            if(nums[begin]>nums[i]){
                left++;
                int temp=nums[i];
                nums[i]=nums[left];
                nums[left]=temp;
            }
        }
        int temp=nums[begin];
        nums[begin]=nums[left];
        nums[left]=temp;
        return left;
    }
}
