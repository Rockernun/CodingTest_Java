import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution {
    private static class Node {
        int destination;
        int cost;

        public Node(int destination, int cost) {
            this.destination = destination;
            this.cost = cost;
        }
    }

    public int solution(int N, int[][] road, int K) {
        List<Node>[] adjacentVillages = new ArrayList[N + 1];

        for (int i = 1; i <= N; i++) {
            adjacentVillages[i] = new ArrayList<>();
        }

        for (int[] roadInfo : road) { 
            adjacentVillages[roadInfo[0]].add(new Node(roadInfo[1], roadInfo[2]));
            adjacentVillages[roadInfo[1]].add(new Node(roadInfo[0], roadInfo[2]));
        }
        
        int[] dist = new int[N + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.add(new Node(1, 0));
        dist[1] = 0; 
        
        while (!pq.isEmpty()) {
            Node currentVillage = pq.poll();
            if (dist[currentVillage.destination] < currentVillage.cost) {
                continue;
            }
            
            for (Node nextVillage : adjacentVillages[currentVillage.destination]) {
                if (dist[nextVillage.destination] > currentVillage.cost + nextVillage.cost) {
                    dist[nextVillage.destination] = currentVillage.cost + nextVillage.cost;
                    pq.add(new Node(nextVillage.destination, dist[nextVillage.destination]));
                }
            }
        }
        
        int result = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] <= K) {
                result++;
            }
        }
        
        return result;
    }
}