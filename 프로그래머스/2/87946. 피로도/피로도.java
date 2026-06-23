class Solution {
    
    int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        boolean[] visited = new boolean[dungeons.length];
        backTrack(dungeons, k, visited, 0);
        return answer;
    }
    
    private void backTrack(int[][] dungeons, int fatigue, boolean[] visited, int depth) {
        if (answer < depth) {
            answer = depth;
        }
        
        for (int i = 0; i < dungeons.length; i++) {
            if (!visited[i] && (fatigue >= dungeons[i][0])) {
                visited[i] = true;
                backTrack(dungeons, fatigue - dungeons[i][1], visited, depth + 1);
                visited[i] = false;
            }
        }
    }
}