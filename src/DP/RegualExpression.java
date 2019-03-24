package DP;

public class RegualExpression {
    public boolean isMatch(String s, String p) {
        if(s.length()==0 && p.length()==0)
            return true;
        if(s.length()!=0 && p.length()==0)
            return false;
        if(s.length()==0){
            if(p.length()%2==1)
                return false;
            int i=1;
            while(i<p.length() && p.charAt(i)=='*')
                i+=2;
            return i==p.length()+1;
        }
        boolean[][] dp=new boolean[s.length()+1][p.length()+1];
        dp[0][0]=true;
        for(int i=1;i<s.length()+1;i++){
            for(int j=1;j<p.length()+1;j++){
                if(s.charAt(i-1)==p.charAt(j-1) || p.charAt(j-1)=='.')
                    dp[i][j]=dp[i-1][j-1];
                else if(p.charAt(j-1)=='*') {
                    if(s.charAt(i-1)!=p.charAt(j-2))
                        dp[i][j] = dp[i][j - 2];
                    else
                        dp[i][j] = (dp[i - 1][j] || dp[i - 1][j - 1] || dp[i][j - 2] || dp[i - 1][j - 2]);
                }else
                    dp[i][j]=false;
            }
        }
        return dp[s.length()][p.length()];
    }
}
