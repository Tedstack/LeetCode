package BinaryTree;
import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class pathSum {
    boolean hasPath=false;
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return hasPath;
        dfs(root,sum,0);
        return hasPath;
    }
    public void  dfs(TreeNode root,int sum,int cur){
        if(root.left==null && root.right==null){
            if(cur+root.val==sum) {
                hasPath = true;
                return;
            }
        }
        if(root.left!=null)
            dfs(root.left,sum,cur+root.val);
        if(root.right!=null)
        dfs(root.right,sum,cur+root.val);
    }

    private List<List<Integer>> result;
    private List<Integer> sol;
    public List<List<Integer>> pathSum2(TreeNode root, int sum) {
       if(root==null)
           return null;
       result=new ArrayList<>();
       sol=new ArrayList<>();
       dfsForall(root,sum,0);
       return result;
    }

    public void dfsForall(TreeNode root,int sum,int cur){
        sol.add(root.val);
        if(root.left==null && root.right==null){
            if(cur+root.val==sum)
                result.add(new ArrayList<>(sol));
            sol.remove(sol.size()-1);
            return;
        }
        if(root.left!=null)
            dfsForall(root.left,sum,cur+root.val);
        if(root.right!=null)
            dfsForall(root.right,sum,cur+root.val);
        this.sol.remove(sol.size()-1);
    }
}
