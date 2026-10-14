import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                int j = stack.pop();
                answer[j] = i - j;
            }
            
            stack.push(i);
        }
        
        while (!stack.isEmpty()) {
            int j = stack.pop();
            answer[j] = prices.length - 1 - j;
        }
        
        return answer;
    }
}