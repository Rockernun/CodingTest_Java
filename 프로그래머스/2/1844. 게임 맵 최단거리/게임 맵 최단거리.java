import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(0, 0, n, m, 1, maps);
    }
    
    private int bfs(int startX, int startY, int n, int m, int count, int[][] maps) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, count});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                return current[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nX = current[0] + dx[i];
                int nY = current[1] + dy[i];
                if (nX < 0 || nX >= n || nY < 0 || nY >= m) continue;
                if (visited[nX][nY] || maps[nX][nY] == 0) continue;
                visited[nX][nY] = true;
                queue.offer(new int[]{nX, nY, current[2] + 1});
            }
        }
        
        return -1;
    }
}