import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int row = relation.length;
        int col = relation[0].length;
        List<Integer> candidateKeys = new ArrayList<>();
        
        for (int mask = 1; mask < (1 << col); mask++) {
            boolean containsKey = false;
            
            for (int key : candidateKeys) {
                if ((mask & key) == key) {
                    containsKey = true;
                    break;
                }
            }
            
            if (containsKey) continue;
            
            Set<String> unique = new HashSet<>();
            
            for (int r = 0; r < row; r++) {
                StringBuilder sb = new StringBuilder();
                
                for (int c = 0; c < col; c++) {
                    if (((mask >> c) & 1) == 1) sb.append(relation[r][c]);
                }
                
                unique.add(sb.toString());  
            }
            
            if (unique.size() == row) candidateKeys.add(mask);
        }
        
        return candidateKeys.size();
    }
}