import java.util.*;

class Solution {
    public int solution(int[][] points, int[][] routes) {
        List<List<int[]>> paths = new ArrayList<>();
        int maxTime = 0;
        for (int[] route : routes) {
            List<int[]> path = buildPath(points, route);
            paths.add(path);
            maxTime = Math.max(maxTime, path.size());
        }

        int answer = 0;
        int[][] robots = new int[101][101];      

        for (int t = 0; t < maxTime; t++) {
            for (List<int[]> path : paths) {
                if (t >= path.size()) continue;         
                int[] pos = path.get(t);
                robots[pos[0]][pos[1]]++;
                if (robots[pos[0]][pos[1]] == 2) answer++;   
            }

            for (List<int[]> path : paths) {
                if (t >= path.size()) continue;
                int[] pos = path.get(t);
                robots[pos[0]][pos[1]] = 0;
            }
        }

        return answer;
    }

    private List<int[]> buildPath(int[][] points, int[] route) {
        List<int[]> path = new ArrayList<>();
        int r = points[route[0] - 1][0];             
        int c = points[route[0] - 1][1];
        path.add(new int[]{r, c});             

        for (int k = 1; k < route.length; k++) {
            int tr = points[route[k] - 1][0];
            int tc = points[route[k] - 1][1];

            while (r != tr) {            
                r += (tr > r) ? 1 : -1;
                path.add(new int[]{r, c});
            }
            while (c != tc) {               
                c += (tc > c) ? 1 : -1;
                path.add(new int[]{r, c});
            }
        }
        return path;
    }
}