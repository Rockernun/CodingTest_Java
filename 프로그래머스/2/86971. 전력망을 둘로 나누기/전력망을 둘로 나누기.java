import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> adjList;
    boolean[] visited;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            int node1 = wire[0];
            int node2 = wire[1];
            
            adjList.get(node1).add(node2);
            adjList.get(node2).add(node1);
        }
        
        for (int[] wire : wires) {
            int cut1 = wire[0];
            int cut2 = wire[1];
            
            adjList.get(cut1).remove(Integer.valueOf(cut2));
            adjList.get(cut2).remove(Integer.valueOf(cut1));
            
            int count = dfs(1, new boolean[n + 1]);
            answer = Math.min(answer, Math.abs(n - 2 * count));
            
            adjList.get(cut1).add(cut2);
            adjList.get(cut2).add(cut1);
        }
        
        return answer;
    }
    
    private int dfs(int start, boolean[] visited) {
        int count = 1;
        visited[start] = true;
        
        for (int next : adjList.get(start)) {
            if (!visited[next]) {
                count += dfs(next, visited);
            }
        }
        
        return count;
    }
}