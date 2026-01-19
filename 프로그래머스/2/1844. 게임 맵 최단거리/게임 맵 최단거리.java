import java.util.Deque;
import java.util.LinkedList;

class Solution {
    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];
        Deque<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == maps.length - 1 && current[1] == maps[0].length - 1) {
                return current[2];
            }

            for (int i = 0; i < 4; i++) {
                int nX = current[0] + dx[i];
                int nY = current[1] + dy[i];

                if (nX >= 0 && nY >= 0 && nX < maps.length && nY < maps[0].length && maps[nX][nY] == 1 && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    queue.add(new int[]{nX, nY, current[2] + 1});
                }
            }
        }

        return -1;
    }
}