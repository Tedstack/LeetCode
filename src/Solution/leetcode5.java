package Solution;

public class leetcode5 {
    public String longestPalindrome(String s) {
        int length=s.length();
        if(length<=1)
            return s;
        boolean[][] dp=new boolean[length][length];
        dp[0][0]=true;
        for(int i=1;i<length;i++){
            dp[i][i]=true;//每个元素对自己一定回文
            dp[i][i-1]=true;
        }
        int subLeft=0,subRight=0;
        for(int k=2;k<=length;k++){
            for(int i=0;i<length-k+1;i++){
                if(s.charAt(i)==s.charAt(i+k-1) && dp[i+1][i+k-2]){
                    dp[i][i+k-1]=true;
                    if(subRight-subLeft+1<k){
                        subLeft=i;
                        subRight=i+k-1;
                    }
                }
            }
        }
        return s.substring(subLeft,subRight+1);
    }
}
