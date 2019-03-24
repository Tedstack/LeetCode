package Array;

import DS.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class Merge {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result=new ArrayList<>();
        if(intervals.size()==0)
            return result;
        PriorityQueue<Interval> queue=new PriorityQueue<Interval>(intervals.size(), new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if(o1.start<o2.start)
                    return -1;
                else if(o1.start==o2.start)
                    return 0;
                else
                    return 1;
            }
        });
        for(int i=0;i<intervals.size();i++){
            queue.add(intervals.get(i));
        }
        while(queue.size()>0){
            Interval i1=queue.poll();
            Interval i2=queue.poll();
            if(i2==null){
                result.add(i1);
                break;
            }
            if(i1.end>=i2.start){
               Interval interval=new Interval(i1.start,Math.max(i1.end,i2.end));
               queue.add(interval);
            }else{
                result.add(i1);
                queue.add(i2);
            }
        }
        return result;
    }

    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if(newInterval==null)
            return intervals;
        List<Interval> result=new ArrayList<>();
        if(intervals.size()==0)
            result.add(newInterval);
        else {
            boolean isAdd=false;
            for (Interval interval : intervals) {
                if (isAdd || interval.end < newInterval.start)
                    result.add(interval);
                else if (interval.start > newInterval.end) {
                    isAdd=true;
                    result.add(newInterval);
                    result.add(interval);
                } else if (interval.end <= newInterval.end)
                    newInterval = new Interval(Math.min(interval.start, newInterval.start), newInterval.end);
                else if (interval.start >= newInterval.start)
                    newInterval = new Interval(newInterval.start, Math.max(newInterval.end, interval.end));
                else {
                    isAdd=true;
                    result.add(interval);
                }
            }
            if(!isAdd)
                result.add(newInterval);
        }
        return result;
    }
}
