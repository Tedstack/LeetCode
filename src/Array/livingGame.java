package Array;

public class livingGame {
    public void gameOfLife(int[][] board) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                int count=countOne(board,i,j);
                if(board[i][j]==0){
                    if(count==3)
                        board[i][j]=2;
                }else{
                    if(count<2 || count>3)
                        board[i][j]=-1;
                }
            }
        }
        for(int i=0;i<board.length;i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(board[i][j]==2)
                    board[i][j]=1;
                else if(board[i][j]==-1)
                    board[i][j]=0;
            }
        }
    }

    private int countOne(int[][] board,int x,int y){
        int count=0;
        int row=board.length;
        int col=board[0].length;
        for(int i=-1;i<2;i++){
            for(int j=-1;j<2;j++){
                if(0<=x+i && x+i<row && 0<=y+j && y+j<col){
                    if(i!=0 || j!=0){
                        if(Math.abs(board[x+i][y+j])==1)
                            count++;
                    }
                }
            }
        }
        return count;
    }
}
