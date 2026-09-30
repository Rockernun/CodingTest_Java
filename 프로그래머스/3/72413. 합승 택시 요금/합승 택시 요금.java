import java.util.*;

class Solution {
    
    Map<Integer, List<int[]>> adjList;
    int answer = Integer.MAX_VALUE;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        adjList = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] fare : fares) {
            int node1 = fare[0];
            int node2 = fare[1];
            int fee = fare[2];
            
            adjList.get(node1).add(new int[]{node2, fee});
            adjList.get(node2).add(new int[]{node1, fee});
        }
        
        int[] fee1 = calculateTaxiFee(n, s);
        int[] fee2 = calculateTaxiFee(n, a);
        int[] fee3 = calculateTaxiFee(n, b);
        
        for (int i = 1; i <= n; i++) {
            if (fee1[i] == Integer.MAX_VALUE || fee2[i] == Integer.MAX_VALUE || fee3[i] == Integer.MAX_VALUE) {
                continue;
            }
            
            answer = Math.min(answer, fee1[i] + fee2[i] + fee3[i]);
        }    
        
        return answer;
    }
    
    private int[] calculateTaxiFee(int n, int start) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{start, 0});
        dist[start] = 0;
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            
            if (current[1] > dist[current[0]]) continue;
            
            for (int[] next : adjList.get(current[0])) {
                int cost = current[1] + next[1];
                
                if (cost < dist[next[0]]) {
                    dist[next[0]] = cost;
                    pq.offer(new int[]{next[0], cost});
                }
            }
        }
        
        return dist;
    }
}