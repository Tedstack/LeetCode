package Solution;

import java.util.Stack;

public class leetcode42 {
    public int trap(int[] height) {
        if(height.length==0)
            return 0;
        int result=0,size=height.length;
        int[] max_left=new int[size],max_right=new int[size];
        max_left[0]=height[0];
        for(int i=1;i<size;i++)
            max_left[i]=Math.max(height[i],max_left[i-1]);
        max_right[size-1]=height[size-1];
        for(int i=size-2;i>=0;i--)
            max_right[i]=Math.max(height[i],max_right[i+1]);
        for(int i=1;i<size-1;i++)
            result+=Math.min(max_left[i],max_right[i])-height[i];
        return result;
    }

    public int trap_verion2(int[] height) {
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, n = height.length, res = 0;
        while (i < n) {
            if (s.isEmpty() || height[i] <= height[s.peek()]) {
                s.push(i++);
            } else {
                int t = s.pop();
                if (s.isEmpty()) continue;
                res += (Math.min(height[i], height[s.peek()]) - height[t]) * (i - s.peek() - 1);
            }
        }
        return res;
    }
}
