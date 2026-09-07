class Solution {
    
    int[] dx = {1, 0, 0, -1};
    int[] dy = {0, -1, 1, 0}; 
    char[] dir = {'d', 'l', 'r', 'u'};
        
    public String solution(int n, int m, int x, int y, int r, int c, int k) {
        int distance = Math.abs(r - x) + Math.abs(c - y);
        if (distance > k || (k - distance) % 2 == 1) {
            return "impossible";
        }
        
        StringBuilder sb = new StringBuilder();
        int cX = x;
        int cY = y;
        
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 4; j++) {
                int nX = cX + dx[j];
                int nY = cY + dy[j];
                
                if (nX < 1 || nX > n || nY < 1 || nY > m) {
                    continue;
                }
                
                int left = k - i - 1;
                int dist = Math.abs(nX - r) + Math.abs(nY - c);
                
                if (dist <= left && (left - dist) % 2 == 0) {
                    cX = nX;
                    cY = nY;
                    sb.append(dir[j]);
                    break;
                }
            }
        }
        
        return sb.toString();
    }
}