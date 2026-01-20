import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    static Deque<Integer> queue;
    static boolean[] visited;

    public int solution(int n, int[][] computers) {
        int result = 0;
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                bfs(i, computers, n);
                result++;
            }
        }

        return result;
    }

    static void bfs(int number, int[][] computers, int n) {
        queue = new ArrayDeque<>();
        queue.offer(number);
        visited[number] = true;

        while (!queue.isEmpty()) {
            Integer currentComputer = queue.poll();
            for (int i = 0; i < computers.length; i++) {
                if (!visited[i] && computers[currentComputer][i] == 1) {
                    visited[i] = true;
                    queue.offer(i);
                }
            }
        }
    }
}