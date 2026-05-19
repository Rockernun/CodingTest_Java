import java.util.*;

class Solution {
    
    static List<List<Integer>> tree;
    static int maxSheep = 0;
    
    public int solution(int[] info, int[][] edges) {
        tree = new ArrayList<>();
        
        for (int i = 0; i < info.length; i++) {
            tree.add(new ArrayList<>());
        }
        
        for (int[] edge : edges) {
            tree.get(edge[0]).add(edge[1]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        candidates.add(0);
        
        dfs(candidates, 0, 0, info);
        return maxSheep;
    }
    
    private void dfs(List<Integer> candidates, int wolf, int sheep, int[] info) {
        for (int i = 0; i < candidates.size(); i++) {
            int current = candidates.get(i);
            
            int wolfSum = wolf;
            int sheepSum = sheep;
            
            if (info[current] == 0) {
                sheepSum++;
            } else {
                wolfSum++;
            }
            
            if (wolfSum >= sheepSum) {
                continue;
            }
            
            maxSheep = Math.max(maxSheep, sheepSum);
            
            List<Integer> newCandidates = new ArrayList<>(candidates);
            newCandidates.remove(i);
            newCandidates.addAll(tree.get(current));
            
            dfs(newCandidates, wolfSum, sheepSum, info);
        }
    }
}