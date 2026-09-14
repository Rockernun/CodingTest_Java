class Solution {
    public int solution(int[] stones, int k) {
        int minStoneVal = 1;
        int maxStoneVal = 200_000_000;
        
        while (minStoneVal <= maxStoneVal) {
            int mid = (minStoneVal + maxStoneVal) / 2;  // mid명이 건널 수 있는지 가정
            
            if (canCross(stones, k, mid)) {
                minStoneVal = mid + 1;
            } else {
                maxStoneVal = mid - 1;
            }
        }
        
        return minStoneVal - 1;
    }
    
    private boolean canCross(int[] stones, int k, int mid) {
        int consecutive = 0;
        
        for (int stone : stones) {
            if (stone < mid) {
                consecutive++;
                
                if (consecutive >= k) {
                    return false;
                }
            } else {
                consecutive = 0;
            }
        }
        
        return true;
    }
}