package Recursive;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums==null || nums.length==0)
            return  res;
        help(res,new ArrayList<>(),nums);
        return res;
    }
    private void help(List<List<Integer>> res,List<Integer> list,int[] nums){
        if(list.size()==nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(list.contains(nums[i]))
                continue;
            list.add(nums[i]);
            help(res,list,nums);
            list.remove(list.size()-1);
        }
    }
    public String getPermutation(int n, int k) {
        if(n==1){
            return "1";
        }
        int[] nums=new int[n];
        for(int i=0;i<n;i++)
            nums[i]=i+1;
        for(int i=0;i<k-1;i++){
            nextPermutation(nums);
        }
        String res="";
        for(int i=0;i<n;i++){
           res+=Integer.toString(nums[i]);
        }
        return res;
    }
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
