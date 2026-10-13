import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesInfo = new HashMap<>();
        int answer = 1;
        
        for (String[] c : clothes) clothesInfo.put(c[1], clothesInfo.getOrDefault(c[1], 1) + 1);
        for (int c : clothesInfo.values()) answer *= c;
        
        return answer - 1;
    }
}