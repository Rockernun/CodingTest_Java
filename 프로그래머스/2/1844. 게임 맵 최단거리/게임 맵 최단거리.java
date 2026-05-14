import java.util.*;

class Solution {
    
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        visited = new boolean[n][m];
        
        return bfs(0, 0, 1, maps);
    }
    
    private int bfs(int startX, int startY, int count, int[][] maps) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, count});
        
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            
            if (currentPosition[0] == maps.length - 1 && currentPosition[1] == maps[0].length - 1) {
                return currentPosition[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nX = currentPosition[0] + dx[i];
                int nY = currentPosition[1] + dy[i];
                if (nX >= 0 && nX < maps.length && nY >= 0 && nY < maps[0].length) {
                    if (!visited[nX][nY] && maps[nX][nY] == 1) {
                        queue.offer(new int[]{nX, nY, currentPosition[2] + 1});
                        visited[nX][nY] = true;
                    }
                }
            }
        }
        
        return -1;
    }
}