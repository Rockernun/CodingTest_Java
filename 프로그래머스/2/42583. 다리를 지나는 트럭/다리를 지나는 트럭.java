import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        for (int i = 0; i < bridge_length; i++) {
            queue1.offer(0);
        }
        
        for (int w : truck_weights) {
            queue2.offer(w);
        }
        
        int totalWeight = 0;
        int time = 0;
        
        while (!queue1.isEmpty()) {
            int q1 = queue1.poll();
            totalWeight -= q1;
            
            if (!queue2.isEmpty()) {
                if (queue2.peekFirst() + totalWeight > weight) {
                    queue1.offer(0);
                } else {
                    int q2 = queue2.poll();
                    queue1.offer(q2);
                    totalWeight += q2;
                }
            }
            
            time++;
        }
        
        return time;
    }
}