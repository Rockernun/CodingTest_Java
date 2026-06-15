import java.util.*;

class Solution {
    
    Map<String, Integer> termsValidityPeriod = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String s : terms) {
            String[] split = s.split(" ");
            String term = split[0];
            int validityPeriod = Integer.parseInt(split[1]);
            termsValidityPeriod.put(term, validityPeriod);
        }
        
        List<Integer> result = new ArrayList<>();
        int todayDays = convertToDays(today);
        
        for (int i = 0; i < privacies.length; i++) {
            String[] split = privacies[i].split(" ");
            
            String startDate = split[0];
            String term = split[1];
            
            int startDays = convertToDays(startDate);
            int validityPeriod = termsValidityPeriod.get(term);
            
            int expireDays = startDays + validityPeriod * 28;
            
            if (todayDays >= expireDays) {
                result.add(i + 1);
            }
        }
        
        int[] answer = new int[result.size()];
        
        for (int i = 0; i < result.size(); i++) {
            answer[i] = result.get(i);
        }
        
        return answer;
    }
    
    private int convertToDays(String date) {
        int year = Integer.parseInt(date.substring(0, 4));
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        
        return year * 12 * 28 + month * 28 + day;
    }
}