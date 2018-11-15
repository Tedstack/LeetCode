package Solution;
import DS.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

public class leetcode23 {
    public ListNode mergeKLists2(ListNode[] lists) {
        if(lists.length==0)
            return null;
        ListNode head=null,p=new ListNode(0);
        PriorityQueue<ListNode> queue=new PriorityQueue<ListNode>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if(o1.val<o2.val)
                    return -1;
                else if(o1.val==o2.val)
                    return 0;
                else
                    return 1;
            }
        });
        for(int i=0;i<lists.length;i++){
            if(lists[i]!=null)
                queue.add(lists[i]);
        }
        while(!queue.isEmpty()){
            p.next=queue.poll();
            if(head==null)
                head=p.next;
            p=p.next;
            if(p.next!=null)
                queue.add(p.next);
        }
        return head;
    }
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head=null,p=new ListNode(0);
        int length=lists.length;
        int[] num=new int[length];
        while(check(lists)){
            for(int i=0;i<length;i++){
                if(lists[i]!=null)
                    num[i]=lists[i].val;
                else
                    num[i]=Integer.MAX_VALUE;
            }
            int index=findMinPosition(num);
            p.next=new ListNode(lists[index].val);
            p=p.next;
            lists[index]=lists[index].next;
            if(head==null)
                head=p;
        }
        return head;
    }
    private boolean check(ListNode[] lists){
        int count=0;
        for(int i=0;i<lists.length;i++){
            if(lists[i]==null)
                count++;
        }
        return count!=lists.length;
    }
    private int findMinPosition(int[] num){
        int index=0;
        for(int i=0;i<num.length;i++){
            if(num[i]<=num[index])
                index=i;
        }
        return index;
    }
}
