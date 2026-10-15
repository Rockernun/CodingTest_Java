import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> queue1 = new ArrayDeque<>();
        Deque<Integer> queue2 = new ArrayDeque<>();
        int time = 0;
        
        for (int i = 1; i <= bridge_length; i++) queue1.offer(0);
        for (int i = 0; i < truck_weights.length; i++) queue2.offer(truck_weights[i]);
        
        while (!queue2.isEmpty()) {
            int sum = 0;
            int firstTruck = queue2.peekFirst();
            queue1.poll();
            
            for (int n : queue1) sum += n;
            if (sum + firstTruck > weight) {
                queue1.offer(0);
            } else {
                queue1.offer(queue2.poll());
            }
            
            time++;
        }
        
        while (!queue1.isEmpty()) {
            queue1.poll();
            time++;
        }
        
        return time;
    }
}