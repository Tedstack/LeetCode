package BinaryTree;
import DS.TreeLinkNode;
import jdk.nashorn.api.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class connectTreeNode {
    public void connect(TreeLinkNode root) {
        Stack<TreeLinkNode> stack=new Stack<>();
        Stack<TreeLinkNode> store=new Stack<>();
        if(root!=null) {
            root.next=null;
            stack.add(root);
            TreeLinkNode last=null;
            while(!stack.isEmpty()){
                TreeLinkNode cur=stack.peek();
                while(!stack.isEmpty()) {
                    cur = stack.pop();
                    if(last!=null)
                        last.next=cur;
                    last=cur;
                    store.push(cur);
                }
                cur.next=null;
                while(!store.isEmpty()){
                    cur=store.pop();
                    if(cur.right!=null)
                        stack.push(cur.right);
                    if(cur.left!=null)
                        stack.push(cur.left);
                }
                last=null;
            }
        }
    }
    public void queueConnect(TreeLinkNode root){
        if(root!=null) {
            Queue<TreeLinkNode> queue = new LinkedList<>();
            TreeLinkNode cur,head=null,previous=null;
            queue.offer(root);
            while(queue.size()!=0){
                cur=queue.poll();
                if(head!=null && head==cur){
                    previous.next=null;
                    head=null;
                }else if(previous!=null){
                    previous.next=cur;
                }
                if(cur.left!=null){
                    queue.offer(cur.left);
                    if(head==null)
                        head=cur.left;
                }
                if(cur.right!=null){
                    queue.offer(cur.right);
                    if(head==null)
                        head=cur.right;
                }
                previous=cur;
            }
        }
    }
}
