package Solution;

import java.util.*;

public class leetcode39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
//        Set<List<Integer>> result=new HashSet<>();
//        if(candidates.length==0)
//            return new ArrayList<>();
//        findCombo(result,new ArrayList<Integer>(),0,0,candidates,target);
//        return new ArrayList<>(result);
        List<List<Integer>> result = new ArrayList<>();
        getResult(result, new ArrayList<Integer>(), candidates, target, 0);
        return result;
    }
    private void findCombo(Set<List<Integer>> result,List<Integer> single,int sum,int index,int[] candidates, int target){
        if(index<=target/candidates[0] && sum<=target) {
            if(sum==target) {
                List<Integer> sol=new ArrayList<>(single);
                Collections.sort(sol, new Comparator<Integer>() {
                    @Override
                    public int compare(Integer o1, Integer o2) {
                        return o1-o2;
                    }
                });
                result.add(sol);
            }
            else if(sum<target){
                for (int i = 0; i < candidates.length; i++) {
                    single.add(candidates[i]);
                    findCombo(result, single, sum + candidates[i], index+1, candidates, target);
                }
            }
        }
        if(single.size()>0)
            single.remove(single.size()-1);
    }
    //leetcode41
    private void getResult(List<List<Integer>> result, List<Integer> cur, int candidates[], int target, int start){
        if(target > 0){
            if(start>0 && candidates[start]==candidates[start-1])
                start++;
            for(int i = start; i < candidates.length && target >= candidates[i]; i++){
                cur.add(candidates[i]);
                getResult(result, cur, candidates, target - candidates[i], i+1);
                cur.remove(cur.size() - 1);
            }
        }
        else if(target == 0 ){
            result.add(new ArrayList<Integer>(cur));
        }
    }
}
