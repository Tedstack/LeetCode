package DP;

import java.util.List;

public class maxSquare {
    public int maximalSquare(char[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int row = matrix.length;
        int col = matrix[0].length;
        int result = 0;
        int[][] dp = new int[row + 1][col + 1];//max square length in position [i,j]
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                if (matrix[i - 1][j - 1] == '1')
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                if (dp[i][j] > result)
                    result = dp[i][j];
            }
        }
        return result * result;
    }
}
