import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    
    public int solution(int[][] maps) {
        visited = new boolean[maps.length][maps[0].length];
        Deque<int[]> priorityQueue = new ArrayDeque<>();
        priorityQueue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;
        
        while (!priorityQueue.isEmpty()) {
            int[] currentPosition = priorityQueue.poll();
            if (currentPosition[0] == maps.length - 1 && currentPosition[1] == maps[0].length - 1) {
                return currentPosition[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int nX = currentPosition[0] + dx[i];
                int nY = currentPosition[1] + dy[i];
                
                if (nX >= 0 && nX < maps.length && nY >= 0 && nY < maps[0].length && maps[nX][nY] == 1 && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    priorityQueue.offer(new int[]{nX, nY, currentPosition[2] + 1});
                }
            }
        }
        
        return -1;
    }
}