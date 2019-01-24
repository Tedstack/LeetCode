package Solution;
import DS.*;

public class AddTwoNum {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head=null;
        ListNode p=new ListNode(0);
        int num1=0,num2=0,sum;
        boolean isAdd=false;
        while(l1!=null || l2!=null){
            if(l1!=null){
                num1=l1.val;
                l1=l1.next;
            }
            if(l2!=null){
                num2=l2.val;
                l2=l2.next;
            }
            if(isAdd)
                sum=num1+num2+1;
            else
                sum=num1+num2;
            if(sum>=10) {
                sum = sum - 10;
                isAdd=true;
            }else
                isAdd=false;
            p.next=new ListNode(sum);
            if(head==null)
                head=p.next;
            p=p.next;
        }
        return head;
    }
}
