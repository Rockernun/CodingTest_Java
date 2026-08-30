class Solution {
    
    private Integer D = 1_000_000_007;
    
    public int solution(int m, int n, int[][] puddles) {
        int[][] map = new int[m][n];
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int[] puddle : puddles) {
                    if (puddle[0] == i + 1 && puddle[1] == j + 1) {
                        map[i][j] = -1;
                    }
                }
            }
        }
        
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (map[i][0] == -1) {
                dp[i][0] = 0;
                break;
            }
            dp[i][0] = 1;
        }
        
        for (int i = 0; i < n; i++) {
            if (map[0][i] == -1) {
                dp[0][i] = 0;
                break;
            }
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (map[i][j] == -1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % D;
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}