import java.util.*;

class Solution {

    int[] oils;
    int[] dr = {-1, 1, 0, 0};
    int[] dc = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int rows = land.length;
        int cols = land[0].length;
        oils = new int[cols]; 

        boolean[][] visited = new boolean[rows][cols];
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (!visited[r][c] && land[r][c] == 1) {
                    bfs(land, visited, rows, cols, r, c);
                }
            }
        }
        
        int max = 0;
        for (int o : oils) {
            if (max < o) max = o;
        }
        
        return max;
    }
    
    private void bfs(int[][] land, boolean[][] visited, int n, int m, int row, int col) {
        Set<Integer> allCols = new HashSet<>();
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});
        visited[row][col] = true;
        allCols.add(col);
        int count = 0;
        count++;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int d = 0; d < 4; d++) {
                int nR = current[0] + dr[d];
                int nC = current[1] + dc[d];
                
                if (nR < 0 || nR >= n || nC < 0 || nC >= m) continue;
                if (!visited[nR][nC] && land[nR][nC] == 1) {
                    queue.offer(new int[]{nR, nC});
                    visited[nR][nC] = true;
                    allCols.add(nC);
                    count++;
                }
            }
        }
        
        for (int o : allCols) oils[o] += count;
    }
}