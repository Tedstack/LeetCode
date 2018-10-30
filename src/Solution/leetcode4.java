package Solution;

public class leetcode4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2){
        int length=nums1.length+nums2.length;
        if(length%2==0){
            int num1=findIndexNum(nums1,nums2,length/2);
            int num2=findIndexNum(nums1,nums2,length/2+1);
            return (double)(num1+num2)/2.0;
        }else{
            return (double)findIndexNum(nums1,nums2,(length+1)/2);
        }
    }
    private int findIndexNum(int[] nums1,int[] nums2, int index){
        if(nums1.length==0)
            return nums2[index-1];
        if(nums2.length==0)
            return nums1[index-1];
        boolean isFirst=true;
        int index1=0,index2=0;
        int num1=0,num2=0;
        for(int i=1;i<=index;i++){
            if(index1<nums1.length)
                num1=nums1[index1];
            else
                num1=Integer.MAX_VALUE;
            if(index2<nums2.length)
                num2=nums2[index2];
            else
                num2=Integer.MAX_VALUE;
            if(num1>=num2){
                isFirst=false;
                index2++;
            }else{
                isFirst=true;
                index1++;
            }
        }
        if(isFirst)
            return num1;
        else
            return num2;
    }
}
