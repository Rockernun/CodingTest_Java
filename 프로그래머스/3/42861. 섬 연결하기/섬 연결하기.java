import java.util.Arrays;

class Solution {
    
    int[] parent;
    
    public int solution(int n, int[][] costs) {
        parent = new int[n];
        
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        int answer = 0;
        int bridges = 0;
        
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] cost : costs) {
            if (bridges == n - 1) break;
            if (find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
                bridges++;
            }
        }
        
        return answer;
    }
    
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    private void union(int a, int b) {
        parent[find(b)] = find(a);
    }
}