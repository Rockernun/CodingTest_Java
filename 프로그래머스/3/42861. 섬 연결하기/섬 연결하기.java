import java.util.Arrays;

class Solution {
    
    int[] parent;
    int answer;
    int bridges;
    
    public int solution(int n, int[][] costs) {
        Arrays.sort(costs, (a, b) -> Integer.compare(a[2], b[2]));
        parent = new int[n];
        answer = 0;
        bridges = 0;
        
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
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
    
    // 루트 노드를 찾는 메서드
    private int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }
    
    // 두 집합을 하나의 집합으로 합치기
    private void union(int x, int y) {
        int root1 = find(x);
        int root2 = find(y);
        parent[root2] = root1;
    }
}