import java.util.*;

class Solution {
    
    Map<Integer, List<int[]>> adjList;
    boolean[] visited;
    
    public int solution(int n, int[][] costs) {
        int answer = 0;
        adjList = new HashMap<>();
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] c : costs) {
            int node1 = c[0];
            int node2 = c[1];
            int cost = c[2];
            
            adjList.get(node1).add(new int[]{node2, cost});
            adjList.get(node2).add(new int[]{node1, cost});
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{0, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            
            if (visited[current[0]]) continue;
            answer += current[1];
            visited[current[0]] = true;
            
            for (int[] next : adjList.get(current[0])) {
                if (!visited[next[0]]) {
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }
        
        return answer;
    }
}