import java.util.PriorityQueue;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.offer(s);
        
        int mix = 0;
        
        while (!pq.isEmpty()) {
            if (pq.peek() >= K) return mix;
            if (pq.size() == 1) break;
            int mostMin = pq.poll();
            int secondMin = pq.poll();
            
            int newScoville = mostMin + secondMin * 2;
            pq.offer(newScoville);
            mix++;
        }
        
        if (pq.size() == 1 && pq.peek() < K) return -1;
        return mix;
    }
}