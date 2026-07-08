import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < progresses.length; i++) {
            int day = (100 - progresses[i]) / speeds[i];
            if ((100 - progresses[i]) % speeds[i] != 0) {
                day++;
            }
            queue.offer(day);
        }
        
        while (!queue.isEmpty()) {
            int count = 1;
            int first = queue.poll();
            
            while (!queue.isEmpty() && first >= queue.peekFirst()) {
                int poll = queue.poll();
                count++;
            }
            answer.add(count);
        }
        return answer.stream().mapToInt(i -> i).toArray();
    }
}