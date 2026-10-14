import java.util.*;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        Map<String, String> termInfo = new HashMap<>();
        
        for (String t : terms) {
            String[] split = t.split(" ");
            termInfo.put(split[0], split[1]);
        }
        
        List<Integer> answer = new ArrayList<>();
        
        String[] split1 = today.split("\\.");
        
        int todayToInt = 0;
        todayToInt += Integer.parseInt(split1[0]) * 12 * 28;
        todayToInt += Integer.parseInt(split1[1]) * 28;
        todayToInt += Integer.parseInt(split1[2]);
        
        for (int i = 0; i < privacies.length; i++) {
            int day = 0;
            String[] split2 = privacies[i].split(" ");
            String[] split3 = split2[0].split("\\.");
            
            day += Integer.parseInt(split3[0]) * 12 * 28;
            day += Integer.parseInt(split3[1]) * 28;
            day += Integer.parseInt(split3[2]);
            day += Integer.parseInt(termInfo.get(split2[1])) * 28;
            
            if (day <= todayToInt) answer.add(i + 1);
        }
        
        return answer.stream().mapToInt(i -> i).toArray();
    }
}