package BinaryTree;

import DS.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BSTIterator {
    private int index;
    private List<Integer> list;

    public BSTIterator(TreeNode root) {
        index=0;
        list=new ArrayList<>();
        preOrder(root,list);
    }

    private void preOrder(TreeNode root,List<Integer> list){
        if(root!=null) {
            preOrder(root.left, list);
            list.add(root.val);
            preOrder(root.right,list);
        }
    }

    /** @return the next smallest number */
    public int next() {
        int result=list.get(index);
        index++;
        return result;
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return index<list.size();
    }
}
