import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        }); 
        
        Deque<int[]> taskQueue = new ArrayDeque<>();
        List<int[]> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) list.add(new int[]{i, jobs[i][0], jobs[i][1]});
        
        int[] answer = new int[jobs.length];
        int clock = 0;
        int finished = 0;
        
        while (true) {
            if (finished == jobs.length) break;
        
            for (int i = 0; i < list.size(); i++) {
                if (clock == list.get(i)[1]) {
                    pq.offer(list.get(i));
                    list.remove(i);
                    i--;
                }
            }

            if (!taskQueue.isEmpty()) {  
                taskQueue.peek()[2]--;
                
                if (taskQueue.peek()[2] == 0) {
                    int[] removedTask = taskQueue.poll();
                    answer[removedTask[0]] = clock - removedTask[1];
                    finished++;
                    
                    if (!pq.isEmpty()) {
                        taskQueue.offer(pq.poll());
                    }
                }
            } 
            
            if (taskQueue.isEmpty() && !pq.isEmpty()) taskQueue.offer(pq.poll());
            clock++;
        }
        
        int sum = 0;
        for (int i = 0; i < answer.length; i++) {
            sum += answer[i];
        }
        
        return sum / answer.length;
    }
}