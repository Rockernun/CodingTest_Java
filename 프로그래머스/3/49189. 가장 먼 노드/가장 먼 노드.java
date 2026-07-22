// 간선에 대한 정보가 담겨 있기 때문에 인접 리스트를 구성하는게 좋아 보인다.
// 간선은 양방향 -> 양방향으로 저장할 필요가 있음
// 가장 먼 노드까지의 
import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> adjList;  // 인접 리스트
    boolean[] visited;  // 각 노드의 방문 여부
    
    public int solution(int n, int[][] edge) {
        adjList = new HashMap<>();
        visited = new boolean[n + 1];
        List<int[]> result = new ArrayList<>();
        
        // 간선 정보 초기화
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        // 간선 정보 연결
        for (int[] v : edge) {
            adjList.get(v[0]).add(v[1]);
            adjList.get(v[1]).add(v[0]);
        }
        
        // 1: [3, 2]
        // 2: [1, 4, 3, 5]
        // 3: [1, 6, 2, 4]
        // 4: [2, 3]
        // 5: [2]
        // 6: [3]
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        visited[1] = true;
        
        int far = 0;
        while (!queue.isEmpty()) {
            int[] currentVertex = queue.poll();
            
            for (int a : adjList.get(currentVertex[0])) {
                if (!visited[a]) {
                    queue.offer(new int[]{a, currentVertex[1] + 1});
                    far = currentVertex[1] + 1;
                    result.add(new int[]{a, currentVertex[1] + 1});
                    visited[a] = true;
                }
            }
        }
        
        int count = 0;
        for (int[] a : result) {
            if (a[1] == far) {
                count++;
            }
        }
        return count;
    }
}