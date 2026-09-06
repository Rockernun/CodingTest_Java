import java.util.*;

class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int solution(String[] board) {
        int[] start = new int[2];
        int[] goal = new int[2];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length(); j++) {
                if (board[i].charAt(j) == 'R') {
                    start[0] = i;
                    start[1] = j;
                }
                
                if (board[i].charAt(j) == 'G') {
                    goal[0] = i;
                    goal[1] = j;
                }
            }
        }
        
        boolean[][] visited = new boolean[board.length][board[0].length()];
        Deque<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start[0], start[1], 0});
        visited[start[0]][start[1]] = true;
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            
            if (current[0] == goal[0] && current[1] == goal[1]) {
                return current[2];
            }
            
            for (int i = 0; i < 4; i++) {
                int[] next = slide(board, current, i);
                if (!visited[next[0]][next[1]]) {
                    queue.offer(new int[]{next[0], next[1], current[2] + 1});
                    visited[next[0]][next[1]] = true;
                }
            }
        }
        
        return -1;
    }
    
    private int[] slide(String[] board, int[] current, int i) {
        int cX = current[0];
        int cY = current[1];
        
        while (true) {
            int nX = cX + dx[i];
            int nY = cY + dy[i];
            
            if (nX < 0 || nY < 0 || nX >= board.length || nY >= board[0].length() || board[nX].charAt(nY) == 'D') {
                break;
            }
            
            cX = nX;
            cY = nY;
        }
        
        return new int[]{cX, cY};
    }
}