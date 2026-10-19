import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    
    int[][] map;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
        map = new int[102][102];
        visited = new boolean[102][102];
        
        for (int[] rec : rectangle) {
            for (int r = rec[0] * 2; r <= rec[2] * 2; r++) {
                for (int c = rec[1] * 2; c <= rec[3] * 2; c++) {
                    map[r][c] = 1;
                }
            }
        }
        
        for (int[] rec : rectangle) {
            for (int r = rec[0] * 2 + 1; r < rec[2] * 2; r++) {
                for (int c = rec[1] * 2 + 1; c < rec[3] * 2; c++) {
                    map[r][c] = 0;
                }
            }
        }
        
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{characterX * 2, characterY * 2, 0});
        visited[characterX * 2][characterY * 2] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[0] == itemX * 2 && current[1] == itemY * 2) return current[2] / 2;
            
            for (int d = 0; d < 4; d++) {
                int nX = current[0] + dx[d];
                int nY = current[1] + dy[d];
                
                if (nX < 1 || nX > 101 || nY < 1 || nY > 101) continue;
                if (visited[nX][nY] || map[nX][nY] == 0) continue;
                
                
                queue.offer(new int[]{nX, nY, current[2] + 1});
                visited[nX][nY] = true;
            }
        }
        
        return -1;
    }
}