package List;

import DS.ListNode;

public class SplitLinkList {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode move = root;
        ListNode[] result = new ListNode[k];
        int count = 0;
        while(move!=null){
            count++;
            move = move.next;
        }
        int singleListNum = count/k;
        int num = count%k;
        int larger_num=0;
        move = root;
        for(int i=0;i<k;i++){
            if(move==null){
                result[i] = null;
            } else {
                ListNode newHead = move;
                for(int j=1;j<singleListNum;j++){
                    move=move.next;
                }
                if(singleListNum>0 && larger_num<num){
                    move=move.next;
                    larger_num++;
                }
                ListNode nxt=move.next;
                move.next=null;
                result[i] = newHead;
                move=nxt;
            }
        }
        return result;
    }
}
