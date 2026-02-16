import java.util.List;
import java.util.ArrayList;

class Solution {
    
    static List<Integer>[] wiresInfo;
    static int answer;
    
    public int solution(int n, int[][] wires) {
        wiresInfo = new ArrayList[n + 1];
        answer = Integer.MAX_VALUE;
        
        for (int i = 1; i <= n; i++) {
            wiresInfo[i] = new ArrayList<>();
        }
        
        for (int i = 0; i < wires.length; i++) {
            wiresInfo[wires[i][0]].add(wires[i][1]);
            wiresInfo[wires[i][1]].add(wires[i][0]);
        }

        for (int[] wire : wires) {
            int wireCut1 = wire[0];
            int wireCut2 = wire[1];
            boolean[] visited = new boolean[n + 1];
            
            int count = dfs(1, visited, wireCut1, wireCut2);
            answer = Math.min(answer, Math.abs(count - (n - count)));
        }
        
        return answer;
    }
    
    private int dfs(int start, boolean[] visited, int wireCut1, int wireCut2) {
        visited[start] = true;
        int count = 1;
        
        for (int nextWire : wiresInfo[start]) {
            if (start == wireCut1 && nextWire == wireCut2 || nextWire == wireCut1 && start == wireCut2) {
                continue;
            }
            
            if (!visited[nextWire]) {
                count += dfs(nextWire, visited, wireCut1, wireCut2);
            }
        }
        
        return count;
    }
}