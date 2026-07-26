class Solution {
    
    int answer = 0;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];
        backTrack(dungeons, k, 0);
        return answer;
    }
    
    private void backTrack(int[][] dungeons, int fatique, int count) {  // 현재 피로도(fatique)와 탐험한 던전의 수를 셀(count)
        answer = Math.max(answer, count);
        
        for (int i = 0; i < dungeons.length; i++) {
            int requiredFatique = dungeons[i][0];
            if (!visited[i] && (requiredFatique <= fatique)) {
                visited[i] = true;
                backTrack(dungeons, fatique - dungeons[i][1], count + 1);
                visited[i] = false;
            }
        }
    }
}