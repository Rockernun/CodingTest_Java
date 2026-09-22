import java.util.List;
import java.util.ArrayList;

class Solution {
    
    int[] info;
    int[][] leftOrRight;
    int answer = 0;
    
    public int solution(int[] info, int[][] edges) {
        this.info = info;
        leftOrRight = new int[info.length][2];
        
        for (int i = 0; i < info.length; i++) {
            leftOrRight[i][0] = -1;
            leftOrRight[i][1] = -1;
        }
        
        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            
            if (leftOrRight[parent][0] == -1) {
                leftOrRight[parent][0] = child;
            } else {
                leftOrRight[parent][1] = child;
            }
        }
        
        List<Integer> next = new ArrayList<>();
        addChildren(next, 0);
        dfs(1, 0, next);
        
        return answer;
    }
    
    private void dfs(int sheep, int wolf, List<Integer> candidates) {
        answer = Math.max(answer, sheep);
        
        for (int i = 0; i < candidates.size(); i++) {
            int node = candidates.get(i);
            
            int newSheep = sheep + (info[node] == 0 ? 1 : 0);
            int newWolf = wolf + (info[node] == 1 ? 1 : 0);
            
            if (newSheep <= newWolf) {
                continue;
            }
            
            List<Integer> newCandidates = new ArrayList<>(candidates);
            newCandidates.remove(Integer.valueOf(node));
            addChildren(newCandidates, node);
            
            dfs(newSheep, newWolf, newCandidates);
        }
    }
    
    private void addChildren(List<Integer> next, int startNode) {
        for (int child : leftOrRight[startNode]) {
            if (child != -1) {
                next.add(child);
            }
        }
    }
}