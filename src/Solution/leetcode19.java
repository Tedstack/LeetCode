package Solution;
import DS.ListNode;
/*Given a linked list, remove the n-th node from the end of list and return its head*/
public class leetcode19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=head;
        int length=0;
        while(temp.next!=null){
            length++;
            temp=temp.next;
        }
        int target=length-n+1;
        temp=head;
        if(target==0){
            head=head.next;
        }else {
            for (int i = 0; i < target - 1; i++)
                temp = temp.next;
            temp.next=temp.next.next;
        }
        return head;
    }
}
