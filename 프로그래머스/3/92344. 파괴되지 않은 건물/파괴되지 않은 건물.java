class Solution {
    public int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        
        int[][] diff = new int[n + 1][m + 1];
        for (int[] s : skill) {
            int degree = (s[0] == 1) ? -s[5] : s[5];
            diff[s[1]][s[2]] += degree;
            diff[s[3] + 1][s[2]] -= degree;
            diff[s[1]][s[4] + 1] -= degree;
            diff[s[3] + 1][s[4] + 1] += degree;
        }
        
        for (int r = 0; r < n; r++) {
            for (int c = 1; c < m; c++) {
                diff[r][c] += diff[r][c - 1];
            }
        }
        
        for (int c = 0; c < m; c++) {
            for (int r = 1; r < n; r++) {
                diff[r][c] += diff[r - 1][c];
            }
        }
        
        int answer = 0;
        
        for (int r = 0; r < n; r++) {
            for (int c = 0; c < m; c++) {
                if (board[r][c] + diff[r][c] >= 1) answer++;
            }
        }
        
        return answer;
    }
} 