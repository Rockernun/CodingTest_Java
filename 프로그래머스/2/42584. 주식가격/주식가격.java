// 각 시점에서의 가격 기준 떨어지지 않는 기간 계산
class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        
        
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (prices[i] > prices[j]) {
                    answer[i]++;
                    break;
                }
                answer[i]++;
            }
        }
        
        return answer;
    }
}