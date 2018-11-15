package Solution;
import DS.ListNode;
public class leetcode24 {
    public ListNode swapPairs(ListNode head) {
        if(head==null)
            return head;
        ListNode p=head,q=p.next,r=null;
        while(q!=null){
            if(p==head) {
                p.next=q.next;
                q.next=p;
                head=q;
            }else{
                r.next=q;
                p.next=q.next;
                q.next=p;
            }
            r=p;
            p=p.next;
            if(p!=null)
                q=p.next;
            else
                q=null;
        }
        return head;
    }
}
