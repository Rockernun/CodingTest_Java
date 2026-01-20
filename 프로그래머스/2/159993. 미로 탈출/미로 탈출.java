import java.util.Deque;
import java.util.LinkedList;

class Solution {

    private static final int[] dx = {-1, 1, 0, 0};
    private static final int[] dy = {0, 0, -1, 1};
    static boolean[][] visited;
    static char[][] charInfo;

    public int solution(String[] maps) {
        charInfo = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        int[] startPosition = new int[2];
        int[] leverPosition = new int[2];
        int[] exitGatePosition = new int[2];

        for (int i = 0; i < maps.length; i++) {
            for (int j = 0; j < maps[i].length(); j++) {

                charInfo[i][j] = maps[i].charAt(j);

                if (maps[i].charAt(j) == 'S') {
                    startPosition = new int[]{i, j};
                }

                if (maps[i].charAt(j) == 'L') {
                    leverPosition = new int[]{i, j};
                }

                if (maps[i].charAt(j) == 'E') {
                    exitGatePosition = new int[]{i, j};
                }
            }
        }
        
        int routeToFindLever = bfs(startPosition, leverPosition);
        visited = new boolean[maps.length][maps[0].length()];
        int routeToWayOut = bfs(leverPosition, exitGatePosition);
        
        if (routeToFindLever == 0 || routeToWayOut == 0){
           return -1;
        }
        
        return routeToFindLever + routeToWayOut;
    }

    private int bfs(int[] startPosition, int[] targetPosition) {
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startPosition[0], startPosition[1], 0});

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();
            visited[currentPosition[0]][currentPosition[1]] = true;
            for (int i = 0; i < 4; i++) {
                int nX = currentPosition[0] + dx[i];
                int nY = currentPosition[1] + dy[i];

                if (nX >= 0 && nX < visited.length && nY >= 0 && nY < visited[0].length && charInfo[nX][nY] != 'X' && !visited[nX][nY]) {
                    visited[nX][nY] = true;
                    queue.offer(new int[]{nX, nY, currentPosition[2] + 1});
                }

                if (currentPosition[0] == targetPosition[0] && currentPosition[1] == targetPosition[1]) {
                    return currentPosition[2];
                }
            }
        }

        return 0;
    }
}