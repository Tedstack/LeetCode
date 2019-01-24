import DS.*;
import DepthFirstSearch.IncreasingPath;
import DepthFirstSearch.Itinerary;
import HashTable.*;
import Solution.*;
import BinaryTree.*;

import java.util.List;

public class Test {
    public static void main(String[] args){
        int[] num=new int[]{3,0,6,1,5};
        hIndex ps=new hIndex();
        System.out.println(ps.solution(num));
    }
}
