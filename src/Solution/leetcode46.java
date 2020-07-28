package Solution;
import java.util.*;

public class leetcode46 {
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums); //should do when we have duplicate numbers
        List<List<Integer>> result = new ArrayList<>();
        int[] used = new int[nums.length];
        generate(nums,used,new ArrayList<Integer>(),result);
        return result;
    }

    public void generate(int[] nums, int[] used, List<Integer> single, List<List<Integer>> resultList){
        if(single.size()==nums.length)
            resultList.add(new ArrayList<Integer>(single));
        for(int i=0;i<nums.length;i++) {
            if(used[i]==1) continue;
            // previous number is same. if it is not used, means they are in the same level of dfs, so this number should be skipped.
            if(i>0 && nums[i-1]==nums[i] && used[i-1]==0) continue;
            used[i]=1;
            single.add(nums[i]);
            generate(nums,used,single,resultList);
            single.remove(single.size()-1);
            used[i]=0;
        }
    }
}
