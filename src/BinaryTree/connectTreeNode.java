package BinaryTree;
import DS.TreeLinkNode;
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
}
