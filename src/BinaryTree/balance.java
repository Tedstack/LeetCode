package BinaryTree;
import DS.*;
public class balance {
    public boolean isBalanced(TreeNode root) {
        if(root==null)
            return true;
        else if(Math.abs(getHeight(root.left)-getHeight(root.right))>1)
            return false;
        else
            return isBalanced(root.left) && isBalanced(root.right);
    }
    public int getHeight(TreeNode root){
        if(root==null)
            return 0;
        else
            return 1+Math.max(getHeight(root.left),getHeight(root.right));
    }
}
