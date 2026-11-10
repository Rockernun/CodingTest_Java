import java.util.*;

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[2] != b[2]) return Integer.compare(a[2], b[2]);
            if (a[1] != b[1]) return Integer.compare(a[1], b[1]);
            return Integer.compare(a[0], b[0]);
        });
        
        Deque<int[]> hardDisk = new ArrayDeque<>();
        boolean[] insert = new boolean[jobs.length];
        List<Integer> result = new ArrayList<>();
        
        for (int clock = 0; clock <= 501000; clock++) { 
            if (!hardDisk.isEmpty()) {
                hardDisk.peek()[2]--;            
                if (hardDisk.peek()[2] == 0) {      
                    int[] removed = hardDisk.poll();
                    result.add(clock - removed[1]);    
                }
            }
            
            for (int i = 0; i < jobs.length; i++) {
                if (!insert[i] && jobs[i][0] <= clock) {
                    pq.offer(new int[]{i, jobs[i][0], jobs[i][1]});
                    insert[i] = true;
                }
            }
            
            if (!pq.isEmpty() && hardDisk.isEmpty()) {
                hardDisk.offer(pq.poll());
            }
        }
        
        int answer = 0;
        for (int i = 0; i < result.size(); i++) {
            answer += result.get(i);
        }
        
        return answer / jobs.length;
    }
}