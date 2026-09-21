import java.util.Arrays;

class Solution {
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] degree = new int[n + 1];
        int[] head = new int[n + 2];
        
        for (int[] road : roads) {
            degree[road[0]]++;
            degree[road[1]]++;
        }
        
        for (int i = 1; i <= n; i++) {
            head[i + 1] = head[i] + degree[i];
        }
        
        int[] adj = new int[roads.length * 2];
        int[] pos = head.clone();
        
        for (int[] road : roads) {
            adj[pos[road[0]]++] = road[1];
            adj[pos[road[1]]++] = road[0];
        }
        
        int[] dist = new int[n + 1];
        Arrays.fill(dist, -1);
        dist[destination] = 0;
        
        int[] queue = new int[n + 1];
        int front = 0;
        int rear = 0;
        queue[rear++] = destination;
        
        while (front < rear) {
            int current = queue[front++];
            
            for (int i = head[current]; i < head[current + 1]; i++) {
                int next = adj[i];
                if (dist[next] == -1) {
                    dist[next] = dist[current] + 1;
                    queue[rear++] = next;
                }
            }
        }
        
        int[] answer = new int[sources.length];
        
        for (int i = 0; i < sources.length; i++) {
            answer[i] = dist[sources[i]];
        }
        
        return answer;
    }
}