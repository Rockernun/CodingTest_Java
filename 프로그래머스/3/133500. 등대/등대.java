import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    
    public int solution(int n, int[][] lighthouse) {
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] l : lighthouse) {
            adjList.get(l[0]).add(l[1]);
            adjList.get(l[1]).add(l[0]);
        }
        
        int[][] dp = new int[n + 1][2];
        boolean[] visited = new boolean[n + 1];
        
        dfs(dp, 1, visited);
        return Math.min(dp[1][0], dp[1][1]);
    }
    
    private void dfs(int[][] dp, int start, boolean[] visited) {
        visited[start] = true;
        dp[start][0] = 0;
        dp[start][1] = 1;
        
        for (int adj : adjList.get(start)) {
            if (!visited[adj]) {
                visited[adj] = true;
                dfs(dp, adj, visited); 
                dp[start][0] += dp[adj][1];
                dp[start][1] += Math.min(dp[adj][0], dp[adj][1]);
            }
        }
    }
}