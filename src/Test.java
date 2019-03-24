import DP.*;
import DS.*;
import DepthFirstSearch.DString;
import DepthFirstSearch.IncreasingPath;
import DepthFirstSearch.Itinerary;
import DepthFirstSearch.Topological;
import HashTable.*;
import Solution.*;
import BinaryTree.*;
import Array.*;
import List.*;

import java.util.HashMap;
import java.util.List;

public class Test {
    public static void main(String[] args){
        ListNode head=new ListNode(1);
        head.next=new ListNode(2);
        head.next.next=new ListNode(3);
        head.next.next.next=new ListNode(4);
        head.next.next.next.next=new ListNode(5);
        Reverse ps=new Reverse();
        System.out.println(ps.reverseBetween(head,2,4));
    }
}
