import DS.*;
import Solution.*;


public class Test {
    public static void main(String[] args){
        leetcode23 sol=new leetcode23();
        int[] nums=new int[]{5,5,3,5,1,-5,1,-2};
        ListNode[] lists=new ListNode[3];
        lists[0]=new ListNode(1);
        lists[0].next=new ListNode(4);
        lists[0].next.next=new ListNode(5);
        lists[1]=new ListNode(1);
        lists[1].next=new ListNode(3);
        lists[1].next.next=new ListNode(4);
        lists[2]=new ListNode(2);
        lists[2].next=new ListNode(6);
        ListNode head=sol.mergeKLists(lists);
    }
}
