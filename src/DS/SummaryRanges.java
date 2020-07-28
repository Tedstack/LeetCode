package DS;

import java.util.*;

public class SummaryRanges {
    List<int[]> interval;
    /** Initialize your data structure here. */
    public SummaryRanges() {
        interval = new ArrayList<>();
    }

    public void addNum(int val) {
        boolean alone = true;
        for(int i=0;i<interval.size();i++){
            if(interval.get(i)[0]<=val && interval.get(i)[1]>=val)//overlap
                return;
            if(interval.get(i)[1]+1==val){
                interval.get(i)[1]=val;
                alone = false;
            }
            if(interval.get(i)[0]-1==val){
                interval.get(i)[0]=val;
                alone = false;
            }
            if(i>0 && interval.get(i)[0] == interval.get(i-1)[1]){
                interval.get(i)[0] = interval.get(i-1)[0];
                interval.remove(i-1);
            }
        }

        if(alone){
            interval.add(new int[]{val,val});
        }
    }

    public int[][] getIntervals() {
        Collections.sort(interval, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });
        int[][] result = new int[interval.size()][2];
        for(int i=0;i<interval.size();i++){
            result[i][0]=interval.get(i)[0];
            result[i][1]=interval.get(i)[1];
        }
        return result;
    }
}
