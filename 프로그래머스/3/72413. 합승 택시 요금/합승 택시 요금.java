import java.util.*;

class Solution {
    
    Map<Integer, List<int[]>> adjList;
    int answer;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        adjList = new HashMap<>();
        for (int i = 1; i <= n; i++) adjList.put(i, new ArrayList<>());
        
        for (int[] fare : fares) {
            adjList.get(fare[0]).add(new int[]{fare[1], fare[2]});
            adjList.get(fare[1]).add(new int[]{fare[0], fare[2]});
        }
        
        answer = Integer.MAX_VALUE;
        
        int[] fromS = findBestCourse(n, s);
        int[] fromA = findBestCourse(n, a);
        int[] fromB = findBestCourse(n, b);
        
        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, fromS[i] + fromA[i] + fromB[i]);
        }
        
        return answer;
    }
    
    private int[] findBestCourse(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((x, y) -> Integer.compare(x[1], y[1]));
        pq.offer(new int[]{start, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();

            if (current[1] > dist[current[0]]) continue;
            
            for (int[] next : adjList.get(current[0])) {
                if (dist[next[0]] > dist[current[0]] + next[1]) {
                    dist[next[0]] = dist[current[0]] + next[1];
                    pq.offer(new int[]{next[0], next[1]});
                }
            }
        }
        
        return dist;
    }
}