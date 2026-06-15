 import java.util.*;

class Solution {
    
    Map<String, Integer> termsValidityPeriod = new HashMap<>();
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        for (String s : terms) {
            String term = s.split(" ")[0];
            int validityPeriod = Integer.parseInt(s.split(" ")[1]);
            termsValidityPeriod.put(term, validityPeriod);
        }
        
        List<Integer> termsList = new ArrayList<>();
        boolean[] result = calculateExpireDate(today, privacies);
        int count = 0;
        
        for (int i = 0; i < result.length; i++) {
            if (result[i]) {
                termsList.add(i + 1);
                count++;
            }
        }
        
        int[] answer = new int[count];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = termsList.get(i);
        }
        
        return answer;
    }
    
    private boolean[] calculateExpireDate(String today, String[] privacies) {
        boolean[] haveToExpire = new boolean[privacies.length];
        
        for (int i = 0; i < privacies.length; i++) {
            String startDate = privacies[i].substring(0, 11);  // 동의 날짜
            String term = privacies[i].substring(11);  // 약관
            
            int validityPeriod = termsValidityPeriod.get(term);  // 유효기간
            int year = validityPeriod / 12;
            int month = validityPeriod % 12;
            
            int expireYear = Integer.parseInt(startDate.substring(0, 4)) + year;
            int expireMonth = Integer.parseInt(startDate.substring(5, 7)) + month;
            int expireDay = Integer.parseInt(startDate.substring(8, 10));
            
            if (expireMonth > 12) {
                expireYear++;
                expireMonth = expireMonth % 12; 
            }
            
            int todayYear = Integer.parseInt(today.substring(0, 4));
            int todayMonth = Integer.parseInt(today.substring(5, 7));
            int todayDay = Integer.parseInt(today.substring(8, 10));
            
            if (todayYear > expireYear) {
                haveToExpire[i] = true;
            } else if (todayYear == expireYear && todayMonth > expireMonth) {
                haveToExpire[i] = true;
            } else if (todayYear == expireYear && todayMonth == expireMonth && todayDay >= expireDay) {
                haveToExpire[i] = true;
            }
        }
        return haveToExpire;
    }
}