class Solution { 
    public int[] solution(int target) {
        int[][] dp = new int[target + 1][2];
        int[] singles = new int[22];
        int[] doubles = new int[21];
        int[] triples = new int[21];
        singles[21] = 50;
        
        for (int i = 1; i <= 20; i++) {
            singles[i] = i;
            doubles[i] = i * 2;
            triples[i] = i * 3;
        }
        
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;
            dp[i][1] = 0;
        }
        
        for (int i = 1; i <= target; i++) {
            for (int j = 1; j <= 21; j++) {
                update(dp, i, singles[j], true);
            }
            
            for (int j = 1; j <= 20; j++) {
                update(dp, i, doubles[j], false);
            }
            
            for (int j = 1; j <= 20; j++) {
                update(dp, i, triples[j], false);
            }
        }
        
        return dp[target];
    }
    
    private void update(int[][] dp, int current, int score, boolean isSingleOrBull) {
        int prev = current - score;
        
        if (prev < 0 || dp[prev][0] == Integer.MAX_VALUE) {
            return;
        }
        
        int throwCount = dp[prev][0] + 1;
        int singleOrBullCount = dp[prev][1] + (isSingleOrBull ? 1 : 0);
        
        if (throwCount < dp[current][0] || (throwCount == dp[current][0] && singleOrBullCount > dp[current][1])) {
            dp[current][0] = throwCount;
            dp[current][1] = singleOrBullCount;
        }
    }
}