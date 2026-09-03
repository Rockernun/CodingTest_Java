import java.util.*;

class Solution {
    public int solution(int[][] matrix_sizes) {
        int n = matrix_sizes.length;

        // 1) 차원 배열 p 만들기: 행렬 i 는 p[i] x p[i+1]
        int[] p = new int[n + 1];
        
        for (int i = 0; i < n; i++) {
            p[i] = matrix_sizes[i][0];
        }
        
        p[n] = matrix_sizes[n - 1][1];

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;
                dp[i][j] = Integer.MAX_VALUE;

                for (int k = i; k < j; k++) {
                    int cost = dp[i][k] + dp[k + 1][j] + p[i] * p[k + 1] * p[j + 1];
                    dp[i][j] = Math.min(dp[i][j], cost);
                }
            }
        }

        return dp[0][n - 1];
    }
}