// 0번부터 n-1번까지 컴퓨터가 있음 (0번, 1번, 2번 컴퓨터가 존재)
// 0번은 1번과 연결되어 있음
// 1번은 0번과 연결되어 있음
// 2번은 2번과 연결되어 있음

// 방문 여부를 초기화할 필요는 없음
// 0번부터 시작해서 n-1번까지의 노드를 기준으로 DFS를 수행하면 될 듯
// 모든 DFS 탐색이 종료될 때 count를 1씩 증가시킴
// 모든 노드를 방문했을 때의 count를 반환
import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> adjList;
    boolean[] visited;
    int count = 0;
    
    public int solution(int n, int[][] computers) {
        adjList = new HashMap<>();
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        // 컴퓨터 연결 정보 저장
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // 현재 컴퓨터 번호와 인덱스 번호가 같지 않고, computers[i][j] == 1인 경우
                if (i != j && computers[i][j] == 1) {
                    adjList.get(i).add(j);
                }
            }
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(i);
                count++;
            }
        }
        
        return count;
    }
    
    private void dfs(int current) {
        visited[current] = true;
        
        for (int next : adjList.get(current)) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}