import java.util.*;

class Solution {
    
    static Map<Integer, List<Integer>> adjList;
    static boolean[] visited;
    
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        adjList = new HashMap<>();
        int[] answer = new int[sources.length];
        
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] road : roads) {
            adjList.get(road[0]).add(road[1]);
            adjList.get(road[1]).add(road[0]);
        }
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = bfs(n, sources[i], destination);
        }
        
        return answer;
    }
    
    private int bfs(int n, int start, int destination) {
        visited = new boolean[n + 1];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int[] poll = queue.poll();
        
            if (poll[0] == destination) {
                return poll[1];
            }
            
            for (int adj : adjList.get(poll[0])) {
                if (!visited[adj]) {
                    queue.offer(new int[]{adj, poll[1] + 1});
                    visited[adj] = true;
                }
            }
        }
        
        return -1;
    }
}