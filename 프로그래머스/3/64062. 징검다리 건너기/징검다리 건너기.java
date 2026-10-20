class Solution {
    public int solution(int[] stones, int k) {
        int min = 1;
        int max = 200_000_000;

        while (min <= max) {
            int setPoint = (min + max) / 2;  
            if (canCross(stones, setPoint, k)) {
                min = setPoint + 1;     
            } else {
                max = setPoint - 1;           
            }
        }

        return max;  
    }

    private boolean canCross(int[] stones, int numberOfPeople, int k) {
        int zeros = 0; 
        for (int stone : stones) {
            if (stone < numberOfPeople) {      
                zeros++;
                if (zeros >= k) return false;     
            } else {
                zeros = 0;                        
            }
        }
        return true;
    }
}