package List;

import DS.ListNode;

public class oddEven {
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return head;
        ListNode even_start = head.next;
        ListNode odd_start = head;
        ListNode even=even_start;
        ListNode odd=odd_start;
        while((even.next!=null && even.next.next!=null)||(odd.next!=null && odd.next.next!=null)){
            if(odd.next!=null && odd.next.next!=null){
                odd.next = odd.next.next;
                odd=odd.next;
            }
            if(even.next!=null && even.next.next!=null){
                even.next = even.next.next;
                even = even.next;
            } else{
                even.next=null;
            }
        }
        odd.next=even_start;
        return head;
    }
}
