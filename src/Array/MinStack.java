package Array;

import java.util.ArrayList;
import java.util.List;

public class MinStack {
    List<Integer> list;
    int min;
    public MinStack() {
        list=new ArrayList<>();
        min=Integer.MAX_VALUE;
    }

    public void push(int x) {
        list.add(x);
        if(min>x)
            min=x;
    }

    public void pop() {
        if(list.get(list.size()-1)==min){
            list.remove(list.size()-1);
            int temp=Integer.MAX_VALUE;
            for(int i=0;i<list.size();i++){
                if(temp>list.get(i))
                    temp=list.get(i);
            }
            min=temp;
        }else
            list.remove(list.size()-1);
    }

    public int top() {
        return list.get(list.size()-1);
    }

    public int getMin() {
        return min;
    }
}
