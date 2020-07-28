package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class SubSets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp = new ArrayList<Integer>();
        dfs(res,temp,nums,0);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> temp, int[] nums, int i){
        res.add(temp);
        for(int j=i; j<nums.length;j++){
            temp.add(nums[j]);
            dfs(res,temp,nums,j+1);
            temp.remove(temp.size()-1);
        }
    }
}
