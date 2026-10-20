class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int min = 1;
        int max = 100_000;
        
        while (min <= max) {
            int setPoint = (min + max) / 2;
            if (canSolve(diffs, times, setPoint, limit)) {
                max = setPoint - 1;
            } else {
                min = setPoint + 1;
            }
        }
        
        return min;
    }
    
    private boolean canSolve(int[] diffs, int[] times, int level, long limit) {
        int timePrev = times[0];
        long totalTime = times[0];
        for (int i = 1; i < diffs.length; i++) {
            int timeCur = times[i];
            if (diffs[i] <= level) totalTime += timeCur;
            if (diffs[i] > level) totalTime += (timeCur + timePrev) * (diffs[i] - level) + timeCur;
            timePrev = timeCur;
            if (totalTime > limit) return false;
        }
        
        return true;
    }
}