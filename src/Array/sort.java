package Array;

import java.util.Arrays;

public class sort {
    public void bubblesort(int[] nums){
        for(int i=0;i<nums.length;i++){
            for(int j=0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    public void quicksort(int[] nums,int start,int end){
        if(start<end){
            int piv=quicksortHandler(nums,start,end);
            quicksort(nums,start,piv-1);
            quicksort(nums,piv+1,end);
        }
    }

    public int quicksortHandler(int[] nums,int start,int end){
        int i=start+1;
        int piv=nums[start];
        for(int j=start+1;j<=end;j++){
            if(nums[j]<piv){
                int temp=nums[i];
                nums[i]=nums[j];
                nums[j]=temp;
                i++;
            }
        }
        nums[start]=nums[i-1];
        nums[i-1]=piv;
        return i-1;
    }

    //if from unsorted to sorted and linear time/space. High possibility is bucketSort.
    public void bucketSort(int[] nums){
        if (nums==null || nums.length<2) return;//No need sort;
        int len = nums.length;
        int min=nums[0];
        int max=nums[0];
        for(int i = 0;i<len;i++){
            min=Math.min(min,nums[i]);
            max=Math.max(max,nums[i]);
        }
        int gap = (int)Math.ceil((double)(max-min)/(len-1));//向上取整
        int numBucket = (max-min)/gap+1;
        int[] bucket_min=new int[numBucket];
        int[] bucket_max=new int[numBucket];
        for (int i=0;i<numBucket;i++){
            bucket_min[i]=Integer.MAX_VALUE;
            bucket_max[i]=Integer.MIN_VALUE;
        }
        for(int num:nums){
            int idx=(num-min)/gap;
            bucket_min[idx]=Math.min(bucket_min[idx],num);
            bucket_max[idx]=Math.max(bucket_max[idx],num);
        }
    }
}
