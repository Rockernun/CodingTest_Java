import java.util.Scanner;
import java.util.List; 
import java.util.Deque;
import java.util.ArrayDeque;
 
public class Main {
    
    static int dx[] = {1, -1, 0, 0};
    static int dy[] = {0, 0, -1, 1};
    static int N;
    static int M;
    static int[][] maze;
    static boolean[][] visited;
    
    static void bfs(int x, int y) {
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{x, y});
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int nextX = current[0] + dx[i];
                int nextY = current[1] + dy[i];
                
                if (nextX >= 0 && nextX < N && nextY >= 0 && nextY < M) {
                    if (!visited[nextX][nextY] && maze[nextX][nextY] == 1) {
                        visited[nextX][nextY] = true;
                        queue.offer(new int[]{nextX, nextY});
                        maze[nextX][nextY] = maze[current[0]][current[1]] + 1;
                    }
                }
            }
        }
    }
    
   public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      String[] input1 = sc.nextLine().split(" ");
      N = Integer.parseInt(input1[0]);
      M = Integer.parseInt(input1[1]);
      
      maze = new int[N][M];
      visited = new boolean[N][M];
      
      for (int i = 0; i < N; i++) {
          String mazeInput = sc.next();
          for (int j = 0; j < M; j++) {
              maze[i][j] = mazeInput.charAt(j) - '0';
          }
      }
      
      visited[0][0] = true;
      bfs(0, 0);
      System.out.println(maze[N - 1][M - 1]);
   }
}