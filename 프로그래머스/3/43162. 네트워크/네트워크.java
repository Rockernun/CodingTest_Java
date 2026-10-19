import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> adjComputers;
    boolean[] visited;
    int networks;
    
    public int solution(int n, int[][] computers) {
        adjComputers = new HashMap<>();
        visited = new boolean[n];
        networks = 0;
        
        for (int i = 0; i < n; i++) {
            adjComputers.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < computers.length; i++) {
            for (int j = 0; j < computers.length; j++) {
                if (j != i && computers[i][j] == 1) adjComputers.get(i).add(j);
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i);
                networks++;
            }
        }
        
        return networks;
    }
    
    private void dfs(int computer) {
        for (int next : adjComputers.get(computer)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(next);
            }
        }
    }
}