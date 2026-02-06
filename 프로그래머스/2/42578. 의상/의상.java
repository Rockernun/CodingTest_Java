import java.util.Map;
import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Integer> clothesInfo = new HashMap<>();
        int answer = 1;
        for (String[] clothesAndCategory : clothes) {
            clothesInfo.put(clothesAndCategory[1], clothesInfo.getOrDefault(clothesAndCategory[1], 1) + 1);
        }
        
        for (int clothesCounts : clothesInfo.values()) {
            answer *= clothesCounts;
        }
        
        return answer - 1;
    }
}