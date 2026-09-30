import java.util.*;

class Solution {
    
    Map<Integer, List<int[]>> adjList;
    int[] dist;
    
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        adjList = new HashMap<>();
        dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        for (int i = 1; i <= N; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] r : road) {
            int village1 = r[0];
            int village2 = r[1];
            int time = r[2];
            
            adjList.get(village1).add(new int[]{village2, time});
            adjList.get(village2).add(new int[]{village1, time});
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});  // 현재 마을, 걸린 시간
        dist[1] = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();  // [현재 마을, 현재 마을까지 걸린 시간]
            
            if (current[1] > dist[current[0]]) continue;
            
            for (int[] next : adjList.get(current[0])) {
                int addedTime = current[1] + next[1];
                if (addedTime > K || addedTime >= dist[next[0]]) continue;
                queue.offer(new int[]{next[0], addedTime});
                dist[next[0]] = addedTime;
            }
        }
        
        for (int i = 1; i <= N; i++) {
            if (dist[i] > K) continue;
            answer++;
        }
        
        return answer;
    }
}