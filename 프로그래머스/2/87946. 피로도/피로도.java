class Solution {
    
    int max = 0;  // 최대 탐험 가능한 던전의 수
    int[][] output;
    boolean[] visited;
    
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        output = new int[n][2];
        visited = new boolean[n];
        
        permutation(dungeons, 0, n, n, k);
        return max;
    }
    
    // 순열 메서드
    private void permutation(int[][] dungeons, int depth, int n, int r, int k) {
        if (depth == r) {
            count(output, k);
            return;
        }
        
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = dungeons[i];
                permutation(dungeons, depth + 1, n, r, k);
                visited[i] = false;
            }
        }
    }
    
    // 순열 메서드 내부에서 수행할 계산 로직
    private void count(int[][] orders, int k) {
        int fatique = k;
        int dungeons = 0;
        for (int[] order : orders) {
            if (order[0] > fatique) break;
            fatique -= order[1];
            dungeons++;
        }
        
        if (dungeons > max) max = dungeons;
    }
}