import java.util.*;

class Solution {
    
    static Map<Integer, List<Integer>> edgeInfo;
    static boolean[] visited;
    static Integer answer = Integer.MAX_VALUE;
    
    public int solution(int n, int[][] wires) {
        edgeInfo = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            edgeInfo.put(i, new ArrayList<>());
        }
        
        for (int[] wire : wires) {
            edgeInfo.get(wire[0]).add(wire[1]);
            edgeInfo.get(wire[1]).add(wire[0]);
        }
        
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            List<Integer> output = new ArrayList<>();
            deleteConnection(wire);
            
            for (int i = 1; i < visited.length; i++) {
                if (!visited[i]) {
                    int result = bfs(i);
                    output.add(result);
                }
            }
            
            if (Math.abs(output.get(0) - output.get(1)) < answer) {
                answer = Math.abs(output.get(0) - output.get(1));
            }

            recoverConnection(wire);
        }
        
        return answer;
    }
    
    private int bfs(int start) {
        Deque<Integer> queue = new ArrayDeque<>();
        int count = 0;
        queue.offer(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            count++;
            
            for (int next : edgeInfo.get(current)) {
                if (!visited[next]) {
                    queue.offer(next);
                    visited[next] = true;
                }
            }
        }
        
        return count;
    }
    
    private void deleteConnection(int[] edge) {
        edgeInfo.get(edge[0]).remove(Integer.valueOf(edge[1]));
        edgeInfo.get(edge[1]).remove(Integer.valueOf(edge[0]));
    }
    
    private void recoverConnection(int[] edge) {
        edgeInfo.get(edge[0]).add(edge[1]);
        edgeInfo.get(edge[1]).add(edge[0]);
    }
}