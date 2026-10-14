import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        Deque<int[]> queue = new ArrayDeque<>();
        
        for (int i = 0; i < progresses.length; i++) {
            queue.offer(new int[]{progresses[i], speeds[i]});
        }
        
        while (!queue.isEmpty()) {
            int[] first = queue.poll();
            int remain = 100 - first[0];
            int day = 0;
            
            if (remain % first[1] == 0) {
                day += remain / first[1];
            } else {
                day += remain / first[1] + 1;
            }
            
            if (!queue.isEmpty()) {
                for (int i = 0; i < queue.size(); i++) {
                    int[] poll = queue.poll();
                    poll[0] += poll[1] * day;
                    queue.offer(poll);
                }
            }
            
            // 큐에 들어있는 첫 번째 기능이 완성되어 있을 동안
            int count = 1;
            while (!queue.isEmpty() && queue.peekFirst()[0] >= 100) {
                queue.removeFirst();
                count++;
            }
            
            answer.add(count);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}