package DP;

public class minPathSum {
    public int minPathSum(int[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                int from_top=grid[i][j],from_left=grid[i][j];
                if(i-1>=0 && j-1>=0) {
                    from_top += grid[i - 1][j];
                    from_left += grid[i][j - 1];
                    grid[i][j] = Math.min(from_left, from_top);
                }else if(i-1<0 && j-1>=0)
                    grid[i][j]+=grid[i][j-1];
                else if(j-1<0 && i-1>=0)
                    grid[i][j]+=grid[i-1][j];
            }
        }
        return grid[grid.length-1][grid[0].length-1];
    }
}
