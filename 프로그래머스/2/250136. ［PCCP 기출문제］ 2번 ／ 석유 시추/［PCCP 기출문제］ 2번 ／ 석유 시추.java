import java.util.*;

class Solution {
    
    int answer = 0;
    boolean[][] visited;
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(int[][] land) {
        int[] result = new int[land[0].length];

        visited = new boolean[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    bfs(i, j, land, visited, result);
                }
            }
        }
        
        for (int i = 0; i < result.length; i++) {
            if (result[i] > answer) {
                answer = result[i];
            }
        }
        
        return answer;
    }
    
    private void bfs(int startX, int startY, int[][] land, boolean[][] visited, int[] result) {
        Deque<int[]> queue = new ArrayDeque<>();
        Set<Integer> columnSet = new HashSet<>();

        int count = 0;

        queue.offer(new int[]{startX, startY});
        visited[startX][startY] = true;
        
        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            int currentX = currentPosition[0];
            int currentY = currentPosition[1];

            count++;
            columnSet.add(currentY);

            for (int i = 0; i < 4; i++) {
                int nX = currentX + dx[i];
                int nY = currentY + dy[i];
                
                if (nX < 0 || nX >= land.length || nY < 0 || nY >= land[0].length) {
                    continue;
                }

                if (visited[nX][nY]) {
                    continue;
                }

                if (land[nX][nY] == 0) {
                    continue;
                }

                queue.offer(new int[]{nX, nY});
                visited[nX][nY] = true;
            }
        }

        for (int column : columnSet) {
            result[column] += count;
        }
    }
}