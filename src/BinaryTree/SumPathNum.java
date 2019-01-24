package BinaryTree;

import DS.TreeNode;

public class SumPathNum {
    int sum=0;
    public int sumNumbers(TreeNode root) {
        if(root==null)
            return 0;
        dfs(root,0);
        return sum;
    }
    public void dfs(TreeNode root,int current){
        if(root.left==null && root.right==null) {
            sum += current*10 + root.val;
            return;
        }
        if(root.left!=null)
            dfs(root.left,current*10+root.val);
        if(root.right!=null)
            dfs(root.right,current*10+root.val);
    }
}
