class Solution {
    
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0};
    int[][] maze;
    String answer = "";
    
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        maze = new int[n][m];
        dfs(x - 1, y - 1, r - 1, c - 1, new StringBuilder(), k, 0);
        
        if (answer.equals("")) {
            return "impossible";
        }
        
        return answer;
    }
    
    private void dfs(int currentX, int currentY, int exitX, int exitY, StringBuilder sb, int k, int count) {
        // 현재 위치에서의 맨해튼 거리
        int distance = Math.abs(currentX - exitX) + Math.abs(currentY - exitY);
        int remainDistance = k - count;
        
        if (remainDistance < distance) {
            return;
        }
        
        if ((distance + remainDistance) % 2 == 1) {
            return;
        }
        
        if (count == k) {
            if (currentX == exitX && currentY == exitY) {
                answer = sb.toString();
            } 
            return;
        }
        
        for (int i = 0; i < 4; i++) {
            int nX = currentX + dx[i];
            int nY = currentY + dy[i];
            
            if (nX >= 0 && nX < maze.length && nY >= 0 && nY < maze[0].length) {
                if (i == 0) {
                    sb.append("d");
                } else if (i == 1) {
                    sb.append("l");
                } else if (i == 2) {
                    sb.append("r");
                } else if (i == 3) {
                    sb.append("u");
                }
                
                dfs(nX, nY, exitX, exitY, sb, k, count + 1);
                sb.deleteCharAt(sb.length() - 1);
                
                if (!answer.equals("")) {
                    return;
                }
            }
        }
    }
}