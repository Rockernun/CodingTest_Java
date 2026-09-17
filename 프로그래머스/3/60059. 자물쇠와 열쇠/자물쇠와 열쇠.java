class Solution {
    public boolean solution(int[][] key, int[][] lock) {
        int M = lock.length;
        int N = key.length;
        int size = M + 2 * (N - 1);
        
        for (int rot = 0; rot < 4; rot++) {
            for (int r = 0; r <= size - N; r++) {
                for (int c = 0; c <= size - N; c++) {
                    int[][] board = new int[size][size];
                    
                    for (int i = 0; i < M; i++) {
                        for (int j = 0; j < M; j++) {
                            board[N - 1 + i][N - 1 + j] = lock[i][j];
                        }
                    }

                    for (int i = 0; i < N; i++) {
                        for (int j = 0; j < N; j++) {
                            board[r + i][c + j] += key[i][j];
                        }
                    }

                    if (check(board, M, N)) {
                        return true;
                    }
                }
            }
            
            key = rotate90(key);
        }
        
        return false;
    }
    
    private boolean check(int[][] board, int M, int N) {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                if (board[N - 1 + i][N - 1 + j] != 1) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private int[][] rotate90(int[][] key) {
        int n = key.length;
        int[][] rotated = new int[n][n];
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = key[i][j];
            }
        }
        
        return rotated;
    }
}