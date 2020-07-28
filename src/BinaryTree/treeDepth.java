package BinaryTree;

import DS.TreeNode;

public class treeDepth {
    int depth;
    int bigDepth;
    public int depth(TreeNode root){
        depth = 0;
        dfs(root,0);
        return depth;
    }

    public void dfs(TreeNode node, int depth){
        this.depth+=depth;
        if(node.left!=null)
            dfs(node.left,depth+1);
        if(node.right!=null)
            dfs(node.right,depth+1);
    }

    public int depthV2(TreeNode root){
        bigDepth = 0;
        dfs2(root);
        return bigDepth;
    }

    public void dfs2(TreeNode node){
        if(node!=null){
            bigDepth += depth(node);
            dfs2(node.left);
            dfs2(node.right);
        }
    }
}
