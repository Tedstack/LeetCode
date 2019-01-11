package BinaryTree;
import DS.*;

import java.util.Stack;

public class sameTree {
    boolean isSame=true;
    public boolean isSameTree(TreeNode p, TreeNode q) {
        dfs(p,q);
        return isSame;
    }
    public void dfs(TreeNode p,TreeNode q){
        if((p==null && q==null) || !isSame)
            return;
        else if(p!=null && q!=null){
            dfs(p.left,q.left);
            if(p.val!=q.val)
                isSame=false;
            dfs(p.right,q.right);
        }else
            isSame=false;
    }
}
