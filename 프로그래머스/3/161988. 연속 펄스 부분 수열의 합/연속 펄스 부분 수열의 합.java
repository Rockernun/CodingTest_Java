class Solution {
    public long solution(int[] sequence) {
        int[] startWithPositive = new int[sequence.length];
        int[] startWithNegative = new int[sequence.length];
        
        for (int i = 0; i < sequence.length; i++) {
            if (i % 2 == 0) {
                startWithPositive[i] = sequence[i];
                startWithNegative[i] = -sequence[i];
            } else {
                startWithPositive[i] = -sequence[i];
                startWithNegative[i] = sequence[i];
            }
        }
        
        long[] dp1 = new long[sequence.length];
        long[] dp2 = new long[sequence.length];
        dp1[0] = startWithPositive[0];
        dp2[0] = startWithNegative[0];
        
        for (int i = 1; i < sequence.length; i++) {
            dp1[i] = Math.max(startWithPositive[i] + dp1[i - 1], startWithPositive[i]);
            dp2[i] = Math.max(startWithNegative[i] + dp2[i - 1], startWithNegative[i]);
        }
        
        long max1 = Long.MIN_VALUE;
        long max2 = Long.MIN_VALUE;
        
        for (int i = 0; i < sequence.length; i++) {
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