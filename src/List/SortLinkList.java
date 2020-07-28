package List;

import DS.ListNode;

public class SortLinkList {
    //NlogN, merge sort.
    //merge sort in Array need O(N) storage.
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        ListNode middle=getMiddle(head);
        ListNode middleNext=middle.next;
        middle.next=null;
        ListNode left=sortList(head);
        ListNode right = sortList(middleNext);
        return sort(left,right);
    }

    public ListNode sort(ListNode start, ListNode end){
        ListNode result=null;
        if(start==null && end==null) return null;
        if(start==null) return end;
        if(end==null) return start;
        if(start.val<end.val){
            result = start;
            result.next = sort(start.next,end);
        }else{
            result = end;
            result.next=sort(start,end.next);
        }
        return result;
    }

    public ListNode getMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head;
        while(fast.next!=null && fast.next.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}
