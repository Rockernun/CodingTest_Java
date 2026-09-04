import java.util.*;

class Solution {

    // 자판 배열 정보 (숫자 → {행, 열})
    int[][] position = {
        {3, 1},  // 0
        {0, 0}, {0, 1}, {0, 2},  // 1, 2, 3
        {1, 0}, {1, 1}, {1, 2},  // 4, 5, 6
        {2, 0}, {2, 1}, {2, 2},  // 7, 8, 9
    };

    // 숫자 (숫자 아닌 칸은 -1)
    int[][] dial = {
        {1, 2, 3},
        {4, 5, 6},
        {7, 8, 9},
        {-1, 0, -1}
    };

    // cost[a][b] = 숫자 a에서 b로 이동하는 최소 가중치
    int[][] cost = new int[10][10];

    public int solution(String numbers) {
        initializeCost();

        // dp[L][R] = 지금까지 눌렀고, 왼손이 L, 오른손이 R에 있을 때의 최소 가중치
        // 시작: 왼손 4, 오른손 6
        int INF = Integer.MAX_VALUE;
        int[][] dp = new int[10][10];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[4][6] = 0;

        for (char ch : numbers.toCharArray()) {
            int num = ch - '0';
            int[][] next = new int[10][10];
            for (int[] row : next) {
                Arrays.fill(row, INF);
            }

            for (int L = 0; L <= 9; L++) {
                for (int R = 0; R <= 9; R++) {
                    if (dp[L][R] == INF) continue;  // 도달 불가 상태는 건너뜀
                    if (L == R) continue;  // 두 손이 같은 자리에 있을 수 없음

                    // 1) 왼손으로 num 누르기 (오른손 R 고정)
                    if (num != R) {  // 누를 자리에 오른손이 있으면 왼손으로 못 누름
                        int nc = dp[L][R] + cost[L][num];
                        if (nc < next[num][R]) {
                            next[num][R] = nc;
                        }
                    }

                    // 2) 오른손으로 num 누르기 (왼손 L 고정)
                    if (num != L) {  // 누를 자리에 왼손이 있으면 오른손으로 못 누름
                        int nc = dp[L][R] + cost[R][num];
                        if (nc < next[L][num]) {
                            next[L][num] = nc;
                        }
                    }
                }
            }
            dp = next;
        }

        // 모든 (L, R) 상태 중 최솟값
        int answer = Integer.MAX_VALUE;
        for (int L = 0; L <= 9; L++) {
            for (int R = 0; R <= 9; R++) {
                answer = Math.min(answer, dp[L][R]);
            }
        }
        return answer;
    }

    private void initializeCost() {
        for (int i = 0; i <= 9; i++) {
            dijkstra(i);
        }
    }

    // 숫자 start에서 0~9까지의 최소 이동 가중치를 cost[start][*]에 저장
    private void dijkstra(int start) {
        int sr = position[start][0];
        int sc = position[start][1];

        int[][] dist = new int[4][3];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        dist[sr][sc] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.add(new int[]{0, sr, sc});

        int[] dr = {-1, 1, 0, 0, -1, -1, 1, 1};
        int[] dc = {0, 0, -1, 1, -1, 1, -1, 1};
        int[] w  = {2, 2, 2, 2, 3, 3, 3, 3};

        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int curCost = current[0];
            int r = current[1];
            int c = current[2];

            if (curCost > dist[r][c]) continue;

            for (int i = 0; i < 8; i++) {
                int nr = r + dr[i];
                int nc = c + dc[i];
                if (nr >= 0 && nr < 4 && nc >= 0 && nc < 3 && dial[nr][nc] != -1) {
                    int nextCost = curCost + w[i];
                    if (nextCost < dist[nr][nc]) {
                        dist[nr][nc] = nextCost;
                        pq.add(new int[]{nextCost, nr, nc});
                    }
                }
            }
        }

        for (int n = 0; n <= 9; n++) {
            cost[start][n] = dist[position[n][0]][position[n][1]];
        }
        cost[start][start] = 1; // 제자리 재입력은 가중치 1
    }
}