import java.util.*;

class Solution {
    
    static boolean[] visited;
    static Map<Integer, List<Integer>> adjList;
    
    public int solution(int n, int[][] edge) {
        visited = new boolean[n + 1];
        adjList = new HashMap<>();
        Deque<Integer> queue = new ArrayDeque<>();
        int[] answer = new int[n + 1];
        int count = 0;
        
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int i = 0; i < edge.length; i++) {
		        // 양방향 간선 정보 추가
            adjList.get(edge[i][0]).add(edge[i][1]);
            adjList.get(edge[i][1]).add(edge[i][0]);
        }

        queue.offer(1);
        visited[1] = true;
        
        while (!queue.isEmpty()) {
            int currentNode = queue.poll();
            for (int next : adjList.get(currentNode)) {
                if (!visited[next]) {
		                // 현재 노드 차수에서 1만큼 증가한 값을 다음 노드의 최단거리로 저장
                    answer[next] = answer[currentNode] + 1;
                    queue.add(next);
                    visited[next] = true;
                }
            }
        }
        
        int maxValue = 0;
        
        for (int value : answer) {
            if (value > maxValue) {
                maxValue = value;
            }
        }
        
        for (int value : answer) {
            if (value == maxValue) {
                count++;
            }
        }
        
        return count;
    }
}