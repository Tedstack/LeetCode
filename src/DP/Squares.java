package DP;

import java.util.Arrays;

public class Squares {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=1;i*i<=n;i++) {
            if(i*i==n)
                return 1;
            dp[i * i] = 1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;i+j*j<=n;j++)
                dp[i+j*j]=Math.min(dp[i]+1,dp[i+j*j]);
        }
        return dp[n];
    }
}
