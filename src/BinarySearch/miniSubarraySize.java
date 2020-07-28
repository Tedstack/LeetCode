package BinarySearch;

public class miniSubarraySize {
    public int minSubArrayLen(int s, int[] nums) {
        int[] sum = new int[nums.length+1];
        sum[0]=0;
        int min = Integer.MAX_VALUE;
        for(int i=1;i<nums.length+1;i++) sum[i]=sum[i-1]+sum[i-1];
        for(int i=0; i<nums.length+1;i++){
            int result = binarySearch(s+sum[i],i+1,nums.length, sum);
            if(result == nums.length) continue;
            else
                min= Math.min(min,result);
        }
        return min==Integer.MAX_VALUE ? 0 : min;
    }

    public int binarySearch(int target,int left,int right, int[] sum){
        int mid = (left+right)/2;
        while(left<=right){
            if(sum[mid]>=target)
                right = mid - 1;
            else
                left = mid + 1;
        }
        return left;
    }
}
