class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int delivery = 0;  // 남은 배달량
        int pickup = 0;  // 남은 수거량
        
        for (int i = n - 1; i >= 0; i--) {
            delivery += deliveries[i];
            pickup += pickups[i];
            
            while (delivery > 0 || pickup > 0) {
                answer += (i + 1) * 2;
                delivery -= cap;
                pickup -= cap;
            }
        }
        
        return answer;
    }
}