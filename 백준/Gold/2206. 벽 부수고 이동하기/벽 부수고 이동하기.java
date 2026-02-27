import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

class Main {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static boolean[][][] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] nAndM = sc.nextLine().trim().split(" ");
        int N = Integer.parseInt(nAndM[0]);
        int M = Integer.parseInt(nAndM[1]);

        int[][] mapInfo = new int[N][M];

        for (int i = 0; i < N; i++) {
            String line = sc.nextLine().trim();
            for (int j = 0; j < M; j++) {
                mapInfo[i][j] = line.charAt(j) - '0';
            }
        }

        System.out.println(findShortestRoute(mapInfo));
    }

    private static int findShortestRoute(int[][] maps) {
        int N = maps.length;
        int M = maps[0].length;

        visited = new boolean[N][M][2];
        Deque<int[]> queue = new ArrayDeque<>();

        queue.offer(new int[]{0, 0, 1, 0});
        visited[0][0][0] = true;

        while (!queue.isEmpty()) {
            int[] currentPosition = queue.poll();

            if (currentPosition[0] == N - 1 && currentPosition[1] == M - 1) {
                return currentPosition[2];
            }

            for (int i = 0; i < 4; i++) {
                int nX = currentPosition[0] + dx[i];
                int nY = currentPosition[1] + dy[i];
                
                if (nX >= 0 && nX < maps.length && nY >= 0 && nY < maps[0].length) {
                    if (maps[nX][nY] == 0 && !visited[nX][nY][currentPosition[3]]) {
                        visited[nX][nY][currentPosition[3]] = true;
                        queue.offer(new int[]{nX, nY, currentPosition[2] + 1, currentPosition[3]});
                    } else if (maps[nX][nY] == 1 && currentPosition[3] == 0 && !visited[nX][nY][1]) {
                        visited[nX][nY][1] = true;
                        queue.offer(new int[]{nX, nY, currentPosition[2] + 1, 1});
                    }
                }
            }
        }

        return -1;
    }
}