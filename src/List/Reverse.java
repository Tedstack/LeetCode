package List;

import DS.ListNode;

public class Reverse {
    public ListNode reverseList(ListNode head) {
        ListNode p=null;
        while(head!=null){
            ListNode t=head.next;
            head.next=p;
            p=head;
            head=t;
        }
        return p;
    }
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(m==n)
            return head;
        ListNode start=null,prestart,end,endnext,p;
        if(m==1){
            start=head;
            prestart=null;
        }else{
            p=head;
            for(int i=0;i<m-2;i++){
                p=p.next;
            }
            prestart=p;
            start=p.next;
        }
        p=head;
        for(int i=0;i<n;i++){
            p=p.next;
        }
        end=p;
        endnext=p.next;
        p=start;
        while(p!=end){
            ListNode temp=p.next;
            p.next=endnext;
            endnext=p;
            p=temp;
        }
        if(prestart!=null){
            prestart.next=p;
            p.next=endnext;
            return head;
        }else{
            p.next=endnext;
            return p;
        }
    }
}
