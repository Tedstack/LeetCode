package DP;

import java.util.Collections;
import java.util.List;

public class IntTriangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null)
            return 0;
        if(triangle.size()==1)
            return triangle.get(0).get(0);
        for(int i=1;i<triangle.size();i++){
            for(int j=0;j<i+1;j++){
                if(j-1>=0 && j<=i-1){
                    int left=triangle.get(i).get(j)+triangle.get(i-1).get(j-1);
                    int right=triangle.get(i).get(j)+triangle.get(i-1).get(j);
                    triangle.get(i).set(j,Math.min(left,right));
                }else if(j-1<0){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j));
                }else if(j>i-1){
                    triangle.get(i).set(j,triangle.get(i).get(j)+triangle.get(i-1).get(j-1));
                }
            }
        }
        Collections.sort(triangle.get(triangle.size()-1));
        return triangle.get(triangle.size()-1).get(0);
    }
    private int minEleInList(List<Integer> list){
        if(list.size()==0)
            return 0;
        int min=list.get(0);
        for(int i=1;i<list.size();i++){
            min=Math.min(min,list.get(i));
        }
        return min;
    }
}
