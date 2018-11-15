package Solution;
import DS.ListNode;
/*Merge two sorted linked lists and return it as a new list.
 The new list should be made by splicing together the nodes of the first two lists.*/
public class leetcode21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head=null,p=new ListNode(0);
        int num1=0,num2=0;
        while(l1!=null || l2!=null){
            if(l1!=null) {
                num1 =l1.val;
            }else
                num1=Integer.MAX_VALUE;
            if(l2!=null) {
                num2 =l2.val;
            }else
                num2=Integer.MAX_VALUE;
            if(num1<=num2) {
                p.next = new ListNode(num1);
                l1=l1.next;
            }else{
                p.next = new ListNode(num2);
                l2=l2.next;
            }
            p=p.next;
            if(head==null)
                head=p;
        }
        return head;
    }
}
