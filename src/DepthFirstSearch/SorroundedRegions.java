package DepthFirstSearch;

public class SorroundedRegions {
    public void solve(char[][] board) {
        int depth=board.length;
        if(depth==0)
            return;
        int width=board[0].length;
        boolean[][] visited=new boolean[depth][width];
        for(int i=0;i<depth;i++){
            for(int j=0;j<width;j++){
                if(i==0 || i==depth-1 || j==0 || j==width-1)
                    dfs(board,visited,i,j);
            }
        }
        for(int i=0;i<depth;i++) {
            for (int j = 0; j < width; j++) {
                if(board[i][j]=='O')
                    board[i][j]='X';
                else if(board[i][j]=='*')
                    board[i][j]='O';
            }
        }
    }

    private void dfs(char[][] board,boolean[][] visited,int i,int j){
        if(i<0 || i>=board.length || j<0 || j>=board[0].length || visited[i][j] || board[i][j]=='X')
            return;
        visited[i][j]=true;
        board[i][j]='*';
        dfs(board,visited,i-1,j);
        dfs(board,visited,i+1,j);
        dfs(board,visited,i,j-1);
        dfs(board,visited,i,j+1);
    }
}
