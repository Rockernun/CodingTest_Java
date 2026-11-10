import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        int mix = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.offer(s);
        
        while (!pq.isEmpty()) {
            int current = pq.poll();

            if (current >= K) return mix;
            
            if (!pq.isEmpty()) {
                pq.offer(current + (pq.poll() * 2));
                mix++;
            }
        }
        
        return -1;
    }
}