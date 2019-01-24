package BinaryTree;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class rightView {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result=new ArrayList<>();
        Queue<TreeNode> list=new LinkedList<>();
        TreeNode single_head=null;
        TreeNode pre_node=null;
        if(root==null)
            return result;
        list.offer(root);
        while(!list.isEmpty()){
            TreeNode cur=list.poll();
            if(single_head!=null && single_head==cur){
                result.add(pre_node.val);
                single_head=null;
            }
            if(cur.left!=null) {
                list.offer(cur.left);
                if(single_head==null)
                    single_head=cur.left;
            }
            if(cur.right!=null) {
                list.offer(cur.right);
                if(single_head==null)
                    single_head=cur.right;
            }
            pre_node=cur;
        }
        result.add(pre_node.val);
        return result;
    }

}
