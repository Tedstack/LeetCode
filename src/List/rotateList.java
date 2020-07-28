package List;

import DS.ListNode;

public class rotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if(head==null || k==0)
            return head;
        int length=0;
        ListNode p=head;
        while(p!=null){
            length++;
            p=p.next;
        }
        k=k%length;
        ListNode cur,pre;
        p=head;
        for(int i=0;i<k;i++) {
            cur=head;
            pre=head;
            while (cur.next != null) {
                pre = cur;
                cur = cur.next;
            }
            cur.next=p;
            pre.next=null;
            p=cur;
        }
        return p;
    }
}
