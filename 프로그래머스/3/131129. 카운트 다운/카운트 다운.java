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
        
        // dp 초기화
        for (int i = 1; i <= target; i++) {
            dp[i][0] = Integer.MAX_VALUE;  // 최소로 다트를 던져서 타겟 점수를 만들 수 있는 경우의 수
            dp[i][1] = 0;  // 싱글 + 불 횟수
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
    
    private void update(int[][] dp, int i, int score, boolean isSingleOrBull) {
        int prev = i - score;
        
        if (prev < 0) return;
        if (dp[prev][0] == Integer.MAX_VALUE) return;
        
        int darts = dp[prev][0] + 1;
        int singleOrBullCount = dp[prev][1] + (isSingleOrBull ? 1 : 0);
        
        if (darts < dp[i][0] || (darts == dp[i][0] && singleOrBullCount > dp[i][1])) {
            dp[i][0] = darts;
            dp[i][1] = singleOrBullCount;
        }
    }
}