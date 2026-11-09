import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesInfo = new HashMap<>();
        for (String[] cloth : clothes) clothesInfo.put(cloth[1], clothesInfo.getOrDefault(cloth[1], 1) + 1);
        int answer = 1;
        
        for (int c : clothesInfo.values()) answer *= c;
        return answer - 1;
    }
}