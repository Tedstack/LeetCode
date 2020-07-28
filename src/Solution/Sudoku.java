package Solution;

import java.util.Stack;

public class Sudoku {
    public void solveSudoku(char[][] board) {

        boolean result=solveHelper(board,0,0);
    }

    public boolean solveHelper(char[][] board,int row,int col){
        while(row<9 && col<9){
            if(board[row][col]=='.')
                break;
            if(col==8){
                row++;
                col=0;
            }else
                col++;
        }
        if(row==9)
            return true;
        int newRow=row+col/8;
        int newCol=(col+1)%9;
        for(int num=1;num<=9;num++){
            if(isValid(board,(char)(num+'0'),row,col)){
                board[row][col]=(char)(num+'0');
                boolean result=solveHelper(board,newRow,newCol);
                if(result)
                    return true;
                board[row][col]='.';
            }
        }
        return false;
    }

    private boolean isValid(char[][] board,char number,int x,int y){
        for(int i=0;i<9;i++){
            if(i!=x){
                if(board[i][y]==number)
                    return false;
            }
        }
        for(int i=0;i<9;i++){
            if(i!=y){
                if(board[x][i]==number)
                    return false;
            }
        }
        for(int i=x/3*3;i<x/3*3+3;i++){
            for(int j=y/3*3;j<y/3*3+3;j++){
                if(i!=x && j!=y){
                    if(board[i][j]==number)
                        return false;
                }
            }
        }
        return true;
    }
}
