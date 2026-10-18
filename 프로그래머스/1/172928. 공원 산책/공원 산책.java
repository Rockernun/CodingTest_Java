class Solution {
    
    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};
    
    public int[] solution(String[] park, String[] routes) {
        int row = -1, col = -1;
        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                if (park[i].charAt(j) == 'S') {
                    row = i;
                    col = j;
                }
            }
        }
        
        for (String route : routes) {
            String[] split = route.split(" ");
            String dir = split[0];  // 가야할 방향
            String distance = split[1];  // 가야할 거리
            
            if (dir.equals("N")) {
                int cR = row;
                int cC = col;
                for (int i = 1; i <= Integer.parseInt(distance); i++) {
                    int nR = cR + i * dx[0];
                    int nC = cC + i * dy[0];
                    
                    if (nR < 0 || nR >= park.length || nC < 0 || nC >= park[0].length()) {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    if (park[nR].charAt(nC) == 'X') {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    row = nR;
                    col = nC;
                } 
            } else if (dir.equals("W")) {
                int cR = row;
                int cC = col;
                for (int i = 1; i <= Integer.parseInt(distance); i++) {
                    int nR = cR + i * dx[2];
                    int nC = cC + i * dy[2];
                    
                    if (nR < 0 || nR >= park.length || nC < 0 || nC >= park[0].length()) {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    if (park[nR].charAt(nC) == 'X') {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    row = nR;
                    col = nC;
                }
                    
            } else if (dir.equals("S")) {
                int cR = row;
                int cC = col;
                for (int i = 1; i <= Integer.parseInt(distance); i++) {
                    int nR = cR + i * dx[1];
                    int nC = cC + i * dy[1];
                    
                    if (nR < 0 || nR >= park.length || nC < 0 || nC >= park[0].length()) {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    if (park[nR].charAt(nC) == 'X') {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    row = nR;
                    col = nC;
                }
            } else if (dir.equals("E")) {
                int cR = row;
                int cC = col;
                for (int i = 1; i <= Integer.parseInt(distance); i++) {
                    int nR = cR + i * dx[3];
                    int nC = cC + i * dy[3];
                    
                    if (nR < 0 || nR >= park.length || nC < 0 || nC >= park[0].length()) {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    if (park[nR].charAt(nC) == 'X') {
                        row = cR;
                        col = cC;
                        break;
                    }
                    
                    row = nR;
                    col = nC;
                }
            }
        }
        
        return new int[]{row, col};
    }
}