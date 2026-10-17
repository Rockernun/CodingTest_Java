import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> adjList;
    boolean[] visited;
    int[] dist;
    
    public int solution(int n, int[][] edge) {
        adjList = new HashMap<>();
        visited = new boolean[n + 1];
        dist = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] e : edge) {
            adjList.get(e[0]).add(e[1]);
            adjList.get(e[1]).add(e[0]);
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        dist[1] = 0;
        visited[1] = true;
        
        int far = 0;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            for (int next : adjList.get(current[0])) {
                if (!visited[next]) {
                    queue.offer(new int[]{next, current[1] + 1});
                    dist[next] = current[1] + 1;
                    visited[next] = true;
                    far = Math.max(far, current[1] + 1);
                }
            }
        }
        
        int count = 0;
        
        for (int i = n; i >= 1; i--) {
            if (dist[i] == far) count++;
        }
        
        return count;
    }
}