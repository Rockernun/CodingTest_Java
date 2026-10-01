import java.util.*;

class Solution {
    
    int[][][] dist;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] board) {
        dist = new int[board.length][board.length][4];
        for (int i = 0; i < dist.length; i++) {
            for (int j = 0; j < dist[i].length; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[3], b[3]));
        
        // 시작점에 오른쪽/아래쪽으로 들어왔다고 가정
        dist[0][0][1] = 0;
        dist[0][0][3] = 0;
        pq.offer(new int[]{0, 0, 1, 0});
        pq.offer(new int[]{0, 0, 3, 0});
        
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], dir = current[2], cost = current[3];
            
            if (cost > dist[x][y][dir]) continue;
            
            for (int i = 0; i < 4; i++) {  // 상하좌우
                int nX = x + dx[i];
                int nY = y + dy[i];
                
                if (nX >= 0 && nX < board.length && nY >= 0 && nY < board.length) {
                    if (board[nX][nY] != 1) {
                        int newCost = cost + (i == dir ? 100 : 600);
                        
                        if (newCost < dist[nX][nY][dir]) {
                            dist[nX][nY][dir] = newCost;
                            pq.offer(new int[]{nX, nY, i, newCost});
                        }
                    }
                }
            }
        }
        
        int answer = Integer.MAX_VALUE;
        for (int i = 0; i < 4; i++) {
            answer = Math.min(answer, dist[board.length - 1][board.length - 1][i]);
        }
        
        return answer;
    }
}