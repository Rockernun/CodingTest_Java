import java.util.List;
import java.util.ArrayList;

class Solution {
    public int solution(int[] picks, String[] minerals) {
        int tools = picks[0] + picks[1] + picks[2];
        int groupCount = (int) Math.ceil((double) minerals.length / 5);
        int usableGroups = Math.min(tools, groupCount);
        
        List<int[]> groups = new ArrayList<>();
        for (int i = 0; i < usableGroups; i++) {
            int diamond = 0;
            int iron = 0;
            int count = 0;
            
            for (int j = 0; j < 5; j++) {
                int idx = i * 5 + j;
                if (idx >= minerals.length) {
                    break;
                }
                
                if (minerals[idx].equals("diamond")) {
                    diamond++;
                } else if (minerals[idx].equals("iron")) {
                    iron++;
                }
                
                count++;
            }
            
            groups.add(new int[]{diamond, iron, count});
        }
        
        groups.sort((a, b) -> {
            if (a[0] != b[0]) {
                return b[0] - a[0];
            }
            
            return b[1] - a[1];
        });
        
        int remainDiamondTools = picks[0];
        int remainIronTools = picks[1];
        int remainStoneTools = picks[2];
        int answer = 0;
        
        for (int[] group : groups) {
            int diamond = group[0];
            int iron = group[1];
            int stone = group[2] - diamond - iron;
            
            if (remainDiamondTools > 0) {
                answer += diamond + iron + stone;
                remainDiamondTools--;
            } else if (remainIronTools > 0) {
                answer += diamond * 5 + iron + stone;
                remainIronTools--;
            } else if (remainStoneTools > 0) {
                answer += diamond * 25 + iron * 5 + stone;
                remainStoneTools--;
            } else {
                break;
            }
        }
        
        return answer;
    }
}