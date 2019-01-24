package DepthFirstSearch;

public class IncreasingPath {
    public int longestIncreasingPath(int[][] matrix) {
        if(matrix==null)
            return 0;
        int max=1;
        int[][] temp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                int tempMax=findPath(matrix,temp,i,j,Integer.MIN_VALUE);
                max=Math.max(max,tempMax);
            }
        }
        return max;
    }
    public int findPath(int[][] matrix,int[][] temp,int i,int j,int cur){
        if(i>=matrix.length || i<0 || j>=matrix[0].length || j<0 || matrix[i][j]<=cur)
            return 0;
        if(temp[i][j]>0)
            return temp[i][j];
        else{
            int current=matrix[i][j];
            int down=findPath(matrix,temp,i+1,j,current)+1;
            int up=findPath(matrix,temp,i-1,j,current)+1;
            int right=findPath(matrix,temp,i,j+1,current)+1;
            int left=findPath(matrix,temp,i,j-1,current)+1;
            temp[i][j]=Math.max(right,Math.max(left,Math.max(down,up)));
            return temp[i][j];
        }
    }
}
