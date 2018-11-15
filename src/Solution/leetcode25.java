package Solution;
import DS.ListNode;
import java.util.Stack;

public class leetcode25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode root=new ListNode(0);
        ListNode current=root,start,tmp;
        boolean end=false;
        Stack<ListNode> stack=new Stack<ListNode>();
        while(head!=null){
            start=head;
            for(int i=0;i<k;i++){
                if(head!=null){
                    tmp = new ListNode(head.val);
                    stack.push(tmp);
                    head=head.next;
                }else{
                    end=true;
                    current.next=start;
                    break;
                }
            }
            while(!stack.isEmpty() && !end){
                current.next=stack.pop();
                current=current.next;
            }
        }
        return root.next;
    }
}
