package DP;

import java.util.Stack;

public class RectangleArea {
    // The number of stack should be increase. When you meet a decrease number. calculate previous height's rectangle area.
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int n = heights.length;
        int curIndex=0, max=0;
        while(curIndex<n){
            if(stack.peek()!=-1 && heights[stack.peek()]>heights[curIndex]){
                max = Math.max(max, heights[stack.pop()]*(curIndex-stack.peek()-1));
            } else {
                stack.push(curIndex);
                curIndex++;
            }
        }
        while(stack.peek()!=-1){
            max=Math.max(max, heights[stack.pop()]*(n-stack.peek()-1));
        }
        return max;
    }

    public int maximalRectangle(char[][] matrix) {
        if(matrix==null || matrix.length==0 || matrix[0].length==0)
            return 0;
        int[] height = new int[matrix[0].length];
        int max=0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(matrix[i][j]=='0')
                    height[j]=0;
                else
                    height[j]++;
            }
            max = Math.max(max,largestRectangleArea(height));
        }
        return max;
    }
}
