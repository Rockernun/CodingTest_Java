class Solution {
    public long solution(int[] sequence) {
        int seqLength = sequence.length;
        
        // +1로 시작하는 펄스 수열과 -1로 시작하는 펄스 수열
        int[] startWithPositive = new int[seqLength];
        int[] startWithNegative = new int[seqLength];
        
        // 각 경우의 펄스 수열을 적용한 최종 수열
        for (int i = 0; i < seqLength; i++) {
            if (i % 2 == 0) {
                startWithPositive[i] = -sequence[i];
                startWithNegative[i] = sequence[i];
            } else {
                startWithPositive[i] = sequence[i];
                startWithNegative[i] = -sequence[i];
            }
        }
        
        long[] dp1 = new long[seqLength];
        long[] dp2 = new long[seqLength];
        
        if (dp1.length == 1) {
            return Math.max(startWithPositive[0], startWithNegative[0]);
        }
        
        // [2, 3, -6, 1, 3, -1, 2, 4]
        // startWithPositive = [2, -3, -6, -1, 3, 1, 2, -4]
        // startWithNegative = [-2, 3, 6, 1, -3, 1, -2, 4]
        
        // dp1 = [2, -1, -6, -1, 3, 4, 6, 2]
        // dp2 = [-2, 3, 9, 10, 7, 8, 6, 10]
        
        dp1[0] = startWithPositive[0];
        dp2[0] = startWithNegative[0];
        
        long max1 = dp1[0];
        long max2 = dp2[0];
        
        // dp[i]: i번까지의 연속 수열의 합과 i번의 원소의 값 중 더 큰 값
        for (int i = 1; i < dp1.length; i++) {
            dp1[i] = Math.max(dp1[i - 1] + startWithPositive[i], startWithPositive[i]);
            dp2[i] = Math.max(dp2[i - 1] + startWithNegative[i], startWithNegative[i]);
            
            if (dp1[i] > max1) {
                max1 = dp1[i];
            }
            
            if (dp2[i] > max2) {
                max2 = dp2[i];
            }
        }
        
        return Math.max(max1, max2);
    }
}