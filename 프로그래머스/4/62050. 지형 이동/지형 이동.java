import java.util.PriorityQueue;
import java.util.Comparator;

class Solution {
    
    static class Node {
        int i;
        int j;
        int cost;
        
        public Node(int i, int j, int cost) {
            this.i = i;
            this.j = j;
            this.cost = cost;
        }
    }
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    
    public int solution(int[][] land, int height) {
        int answer = 0;
        int N = land.length;
        boolean[][] visited = new boolean[N][N];
        
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        pq.offer(new Node(0, 0, 0));
        
        while (!pq.isEmpty()) {
            Node currentPosition = pq.poll();
            
            if (!visited[currentPosition.i][currentPosition.j]) {
                visited[currentPosition.i][currentPosition.j] = true;
                answer += currentPosition.cost;
            } else {
                continue;
            }
            
            for (int i = 0; i < 4; i++) {
                int di = currentPosition.i + dx[i];
                int dj = currentPosition.j + dy[i];
                
                if (di >= 0 && di < N && dj >= 0 && dj < N) {
                    int ladderCost = Math.abs(land[currentPosition.i][currentPosition.j] - land[di][dj]);
                
                    if (ladderCost > height) {
                        pq.offer(new Node(di, dj, ladderCost));
                    } else if (ladderCost <= height) {
                        pq.offer(new Node(di, dj, 0));
                    }
                } else {
                    continue;
                }
            }
        }
        
        return answer;
    }
}