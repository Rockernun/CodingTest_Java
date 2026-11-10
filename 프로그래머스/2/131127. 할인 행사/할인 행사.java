import java.util.Map;
import java.util.HashMap;

class Solution {
    
    Map<String, Integer> junghyunWants;
    int answer;
    
    public int solution(String[] want, int[] number, String[] discount) {
        junghyunWants = new HashMap<>();
        answer = 0;
        
        for (int i = 0; i < want.length; i++) {
            junghyunWants.put(want[i], number[i]);
        }
        
        for (int i = 0; i <= discount.length - 10; i++) {
            Map<String, Integer> marketDiscount = new HashMap<>();
            
            for (int j = i; j < i + 10; j++) {
                marketDiscount.put(discount[j], marketDiscount.getOrDefault(discount[j], 0) + 1);
            }
            
            boolean memberShip = true;
            
            for (String w : junghyunWants.keySet()) {
                if (!marketDiscount.keySet().contains(w) || junghyunWants.get(w) > marketDiscount.get(w)) {
                    memberShip = false;
                    break;
                }
            }
            
            if (memberShip) answer++;
        }
        
        return answer;
    }
}