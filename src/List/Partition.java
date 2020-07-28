package List;

import DS.ListNode;

import java.util.HashMap;

public class Partition {
    public ListNode partitionList(ListNode head, int x) {
        ListNode less=new ListNode(-1);
        ListNode more=new ListNode(-1);
        ListNode lessHead=less;
        ListNode moreHead=more;
        ListNode p=head;
        while(p!=null){
            if(p.val<x){
                less.next=p;
                less=less.next;
            }else{
                more.next=p;
                more=more.next;
            }
            p=p.next;
        }
        less.next=moreHead.next;
        more.next=null;
        return lessHead.next;
    }
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int index1=m-1,index2=n-1,index3=m+n-1;
        while(index3>=0){
            if(index1<0){
                nums1[index3]=nums2[index2];
                index2--;
            }else if(index2<0) {
                nums1[index3]=nums1[index1];
                index1--;
            }else if(nums1[index1]>nums2[index2]){
                nums1[index3]=nums1[index1];
                index1--;
            }else{
                nums1[index3]=nums2[index2];
                index2--;
            }
            index3--;
        }
    }
}
