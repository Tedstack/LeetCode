package Array;

public class MergeSort {
    public void mergeSort(int[] nums){
        if(nums == null || nums.length<2)
            return;
        Process(nums,0,nums.length-1);
    }

    public void Process(int[] nums, int left, int right){
        int mid = left + (right - left)>>1;
        Process(nums,left,mid);
        Process(nums,mid+1,right);
        Merge(nums,left,right);
    }

    public void Merge(int[] nums, int left, int right){
        int mid = left+(right-left)>>1;
        int[] temp = new int[right-left+1];
        int p1=left, p2=mid+1;
        int i=0;
        while(p1<=mid && p2<=right){
            if(nums[p1]<nums[p2]){
                temp[i++] = nums[p1++];
            }else{
                temp[i++]=nums[p2++];
            }
        }
        while(p1<=mid)
            temp[i++] = nums[p1++];
        while(p2<=right)
            temp[i++] = nums[p2++];
        for(int j=0;j<temp.length;j++){
            nums[left+j] = temp[j];
        }
    }
}
