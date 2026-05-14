import java.util.*;

class Solution {
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static boolean[][] visited;
    static int n;
    static int m;
    
    public int solution(String[] maps) {
        n = maps.length;
        m = maps[0].length();
        int[] start = new int[2];
        int[] lever = new int[2];
        int[] exit = new int[2];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (maps[i].charAt(j) == 'S') {
                    start[0] = i;
                    start[1] = j;
                } else if (maps[i].charAt(j) == 'L') {
                    lever[0] = i;
                    lever[1] = j;
                } else if (maps[i].charAt(j) == 'E') {
                    exit[0] = i;
                    exit[1] = j;
                }
            }
        }
        int toLever = bfs(start[0], start[1], lever, 0, maps);
        int toExit = bfs(lever[0], lever[1], exit, 0, maps);
        
        if (toLever != -1 && toExit != -1) {
            return toLever + toExit;
        } else {
            return -1;
        }
    }
    
    private int bfs(int startX, int startY, int[] target, int second, String[] maps) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{startX, startY, second});
        visited = new boolean[n][m];
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            
            if (currentPosition[0] == target[0] && currentPosition[1] == target[1]) {
                return currentPosition[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nX = currentPosition[0] + dx[i];
                int nY = currentPosition[1] + dy[i];
                
                if (nX >= 0 && nX < n && nY >= 0 && nY < m) {
                    int nextMove = maps[nX].charAt(nY);
                    if (!visited[nX][nY]) {
                        if (nextMove != 'X') {
                            queue.offer(new int[]{nX, nY, currentPosition[2] + 1});
                            visited[nX][nY] = true;
                        }
                    }
                }
            }
        }
        return -1;
    }
}