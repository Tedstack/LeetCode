package DepthFirstSearch;

public class countIsLand {
    public int numIslands(char[][] grid) {
        if(grid==null || grid.length==0 || grid[0].length==0)
            return 0;
        int row=grid.length;
        int column=grid[0].length;
        int count=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                if(grid[i][j]=='1'){
                    count++;
                    combine(grid,i,j);
                }
            }
        }
        return count;
    }
    public void combine(char[][] grid,int x,int y){
        grid[x][y]='2';
        if(x>grid.length-1 || y>grid[0].length)
            return;
        if (x < grid.length-1 && grid[x+1][y] == '1') {//向下
            combine(grid,x+1,y);
        }
        if (y < grid[0].length-1 && grid[x][y+1] == '1'){//向右
            combine(grid,x,y+1);
        }
        if (x > 0 && grid[x-1][y] == '1' ){//向上
            combine(grid,x-1,y);
        }
        if (y > 0 && grid[x][y-1] == '1') {//向左
            combine(grid,x,y-1);
        }
    }
}
