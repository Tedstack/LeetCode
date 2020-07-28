package DepthFirstSearch;

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        int row=board.length;
        int col=board[0].length;
        boolean[][] visited=new boolean[row][col];
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(DFS(board,word,0,i,j,visited))
                    return true;
            }
        }
        return false;
    }

    public boolean DFS(char[][] board,String word,int index,int x,int y,boolean[][] visited){
        if(index==word.length())
            return true;
        int row=board.length;
        int col=board[0].length;
        if(x<0 || y<0 || x>=row || y>=col || visited[x][y] || board[x][y]!=word.charAt(index))
            return false;
        visited[x][y]=true;
        boolean res=DFS(board, word, index+1, x+1, y, visited)
                    || DFS(board, word, index+1, x-1, y, visited)
                    || DFS(board, word, index+1, x, y+1, visited) || DFS(board, word, index+1, x, y-1, visited);
        visited[x][y]=false;
        return res;
    }
}
