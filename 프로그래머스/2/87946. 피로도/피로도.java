class Solution {
    
    boolean[] visited;
    int max = 0;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        dfs(dungeons, k, 0);
        return max;
    }
    
    private void dfs(int[][] dungeons, int fatigue, int depth) {
        max = Math.max(max, depth);
        for (int i = 0; i < dungeons.length; i++) {
            if (visited[i] || fatigue < dungeons[i][0]) continue;
            visited[i] = true;
            dfs(dungeons, fatigue - dungeons[i][1], depth + 1);
            visited[i] = false;
        }
    }
}