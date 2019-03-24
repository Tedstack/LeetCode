package BreadthFirstSearch;

import DS.*;
import java.util.*;

public class BinaryTree {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null)
            return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        TreeNode cur, head = null;
        queue.offer(root);
        while (queue.size() != 0) {
            cur = queue.poll();
            if (head != null && head == cur) {
                result.add(level);
                level = new ArrayList<>();
                head = null;
            }
            level.add(cur.val);
            if (cur.left != null) {
                queue.offer(cur.left);
                if (head == null)
                    head = cur.left;
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                if (head == null)
                    head = cur.right;
            }
        }
        result.add(level);
        return result;
    }
    public List<Integer> reverse(List<Integer> list){
        List<Integer> temp=new ArrayList<>();
        for(Integer i:list){
            temp.add(0,i);
        }
        return temp;
    }
}
