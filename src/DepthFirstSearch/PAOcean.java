package DepthFirstSearch;

import java.util.ArrayList;
import java.util.List;

public class PAOcean {
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> result=new ArrayList<>();
        if(matrix.length==0)
            return result;
        boolean[][] pacific=new boolean[matrix.length][matrix[0].length];
        boolean[][] atlantic=new boolean[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            dfs(matrix,pacific,i,0);
            dfs(matrix,atlantic,i,matrix[0].length-1);
        }
        for(int j=0;j<matrix[0].length-1;j++){
            dfs(matrix,pacific,0,j);
            dfs(matrix,atlantic,matrix.length-1,j);
        }
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                if(pacific[i][j] && atlantic[i][j]){
                    int[] sol=new int[2];
                    sol[0]=i;
                    sol[1]=j;
                    result.add(sol);
                }
            }
        }
        return result;
    }
    public void dfs(int[][] matrix,boolean[][] flow,int i,int j){
        if(flow[i][j])
            return;
        flow[i][j]=true;
        if(i-1>=0 && matrix[i-1][j]>=matrix[i][j])
            dfs(matrix,flow,i-1,j);
        if(i+1<matrix.length && matrix[i+1][j]>=matrix[i][j])
            dfs(matrix,flow,i+1,j);
        if(j-1>=0 && matrix[i][j-1]>=matrix[i][j])
            dfs(matrix,flow,i,j-1);
        if(j+1<matrix[0].length && matrix[i][j+1]>=matrix[i][j])
            dfs(matrix,flow,i,j+1);
    }
}
