import java.util.HashMap;
import java.util.Map;

class Solution {
    public static int solution(String[] want, int[] number, String[] discount) {
        Map<String, Integer> wantInfo = new HashMap<>();
        int answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            wantInfo.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> discountInfo = new HashMap<>();
            for (int j = 0; j < 10; j++) {
                discountInfo.put(discount[i + j], discountInfo.getOrDefault(discount[i + j], 0) + 1);
            }
            
            if (wantInfo.equals(discountInfo)) {
                answer++;
            }
        }
        
        return answer;
    }
}