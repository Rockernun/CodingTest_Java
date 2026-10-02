import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        Deque<Integer> q1 = new ArrayDeque<>();
        Deque<Integer> q2 = new ArrayDeque<>();
        int count = 0;
        
        long totalQ1 = 0L, totalQ2 = 0L;

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            q2.offer(queue2[i]);
            totalQ1 += queue1[i];
            totalQ2 += queue2[i];
        }
        
        long mid = (totalQ1 + totalQ2) / 2;
        int limit = queue1.length * 4;
        
        while (totalQ1 != mid) {
            if (count > limit) {
                count = -1;
                break;
            }
            
            if (totalQ1 == mid) {
                return count;
            }
            
            if (totalQ1 < mid && q2.size() > 1) {
                int poll = q2.poll();
                q1.offer(poll);
                totalQ1 += poll;
            } else if (totalQ1 > mid && q1.size() > 1) {
                int poll = q1.poll();
                q2.offer(poll);
                totalQ1 -= poll;
            } else {
                count = -1;
                break;
            }
            
            count++;
        }
        
        return count;
    }
}