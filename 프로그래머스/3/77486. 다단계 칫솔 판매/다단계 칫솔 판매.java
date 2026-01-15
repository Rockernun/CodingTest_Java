import java.util.HashMap;
import java.util.Map;

class Solution {
    
    public static final Integer TOOTH_BRUSH_PRICE = 100;
    
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        Map<String, String> memberAndRefereeInfo = new HashMap<>();
        for (int i = 0; i < enroll.length; i++) {
            memberAndRefereeInfo.put(enroll[i], referral[i]);
        }
        
        Map<String, Integer> totalIncomeInfo = new HashMap<>();

        for (int i = 0; i < seller.length; i++) {
            String currentMember = seller[i];
            int income = amount[i] * TOOTH_BRUSH_PRICE;
            
            while (income > 0 && !currentMember.equals("-")) {
                totalIncomeInfo.put(currentMember, totalIncomeInfo.getOrDefault(currentMember, 0) + income - (income / 10));
                currentMember = memberAndRefereeInfo.get(currentMember);
                income /= 10;
            }
        }
        
        int[] result = new int[enroll.length];
        for (int i = 0; i < enroll.length; i++) {
            result[i] = totalIncomeInfo.getOrDefault(enroll[i], 0);
        }
        
        return result;
    }
}