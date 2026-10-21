import java.util.*;

class Solution {
    
    Map<Integer, List<int[]>> adjList;
    
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        adjList = new HashMap<>();
        
        for (int i = 1; i <= n; i++) {
            adjList.put(i, new ArrayList<>());
        }
        
        for (int[] path : paths) {
            adjList.get(path[0]).add(new int[]{path[1], path[2]});
            adjList.get(path[1]).add(new int[]{path[0], path[2]});
        }
        
        boolean[] isGate = new boolean[n + 1];
        boolean[] isSummit = new boolean[n + 1];
        
        for (int i = 0; i < gates.length; i++) isGate[gates[i]] = true;
        for (int i = 0; i < summits.length; i++) isSummit[summits[i]] = true;
        
        int[] intensity = new int[n + 1];
        Arrays.fill(intensity, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        
        for (int g = 0; g < gates.length; g++) {
            intensity[gates[g]] = 0;
            pq.offer(new int[]{gates[g], 0});
        }
        
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int node = cur[0], inten = cur[1];

            if (inten > intensity[node]) continue; 
            if (isSummit[node]) continue;

            for (int[] next : adjList.get(node)) {
                int nextNode = next[0];
                if (isGate[nextNode]) continue; 

                int nextInten = Math.max(inten, next[1]); 
                if (nextInten < intensity[nextNode]) {
                    intensity[nextNode] = nextInten;
                    pq.offer(new int[]{nextNode, nextInten});
                }
            }
        }
        
        Arrays.sort(summits);
        int[] answer = new int[]{0, Integer.MAX_VALUE};
        for (int i = 0; i < summits.length; i++) {
            if (answer[1] > intensity[summits[i]]) {
                answer[0] = summits[i];
                answer[1] = intensity[summits[i]];
            }
        }
        
        return answer;
    }
}