import java.util.*;

class Solution {
    
    boolean[][] visited;
    List<int[]> answer;
    int count;
     
    public int solution(int n) {
        
        count = 0;
        int[] board = new int[n];
        visited = new boolean[n][n];
        answer = new ArrayList<>();
        
        dfs(0, answer, board, n);
        return count;
    }
    
    private void dfs(int row, List<int[]> answer, int[] board, int n) {
        if (row == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (isPossible(row, col, board)) {
                board[row] = col;
                dfs(row + 1, answer, board, n);
                board[row] = -1; 
            }
        }
            
    }
    
    private boolean isPossible(int row, int col, int[] board) {
        for (int prevRow = 0; prevRow < row; prevRow++) {
            if (board[prevRow] == col || Math.abs(board[prevRow] - col) == Math.abs(prevRow - row)) {
                return false;
            }
        }
        return true;
    }
}