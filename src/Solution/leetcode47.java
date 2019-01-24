package Solution;

public class leetcode47 {
    public void rotate(int[][] matrix) {
        if(matrix.length!=0) {
            crossRotate(matrix);
            horRotate(matrix);
        }
    }
    private void crossRotate(int[][] matrix){
        int row=matrix.length;
        for(int i=1;i<row;i++){
            for(int j=0;j<i;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }
    }
    private void horRotate(int[][] matrix){
        int start=0,end=matrix[0].length-1;
        while(start<end){
            for(int i=0;i<matrix.length;i++){
                int temp=matrix[i][start];
                matrix[i][start]=matrix[i][end];
                matrix[i][end]=temp;
            }
            start++;
            end--;
        }
    }
}
