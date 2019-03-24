package Recursive;

import java.util.ArrayList;
import java.util.List;

public class NQueen {
    private int[] chess;
    private int N;
    private List<List<String>> allSolution=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        N=n;
        check(0);
        return allSolution;
    }
    public void check(int n){
        if(n==N){
            List<String> solution=new ArrayList<>();
            for(int i=0;i<N;i++){
                String line="";
                for(int j=0;j<N;j++){
                    if(j==chess[i])
                        line+="Q";
                    else
                        line+=".";
                }
                solution.add(line);
            }
            allSolution.add(solution);
            return;
        }
        for(int i=0;i<N;i++){
            chess[n]=i;
            if(isPut(n)){
                check(n+1);
            }
        }
    }
    private boolean isPut(int n){
        for(int i=0;i<n;i++){
            if(chess[i]==chess[n] || Math.abs(chess[i]-chess[n])==n-i)
                return false;
        }
        return true;
    }
}
