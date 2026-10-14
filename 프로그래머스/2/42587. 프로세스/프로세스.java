import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        Deque<int[]> queue = new ArrayDeque<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[] {i, priorities[i]});
            maxHeap.offer(priorities[i]);
        }

        int turn = 0;
        
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            if (cur[1] < maxHeap.peek()) { 
                queue.offer(cur);
                continue;
            }
            maxHeap.poll();
            turn++;
            if (cur[0] == location) return turn;
        }
        
        return turn;
    }
}