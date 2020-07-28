package List;

import DS.ListNode;

public class reorder {
    public void reorderList(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        if(fast.next!=null)
            slow=slow.next;
        ListNode secondHead = slow.next;
        slow.next=null;
        ListNode p=null;
        while(secondHead!=null){
            ListNode t = secondHead.next;
            secondHead.next=p;
            p=secondHead;
            secondHead=t;
        }
        ListNode temp = head;
        while(p!=null) {
            ListNode pNext = p.next;
            ListNode tNext = temp.next;
            temp.next = p;
            p.next = tNext;
            temp = tNext;
            p = pNext;
        }
    }
}
