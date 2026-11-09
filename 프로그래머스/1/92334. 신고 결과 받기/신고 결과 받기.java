import java.util.*;

class Solution {
    
    Map<String, Set<String>> reportInfo;
    
    public int[] solution(String[] id_list, String[] report, int k) {
        reportInfo = new HashMap<>();
        int[] count = new int[id_list.length];
        for (String id : id_list) reportInfo.put(id, new HashSet<>());
        for (String id : report) reportInfo.get(id.split(" ")[0]).add(id.split(" ")[1]);
        
        for (int i = 0; i < id_list.length; i++) {
            String current = id_list[i];
            
            for (String s1 : reportInfo.keySet()) {
                for (String s2 : reportInfo.get(s1)) {
                    if (s2.equals(current)) count[i]++;
                }
            }
        }
        
        List<String> reportedList = new ArrayList<>();
        for (int i = 0; i < id_list.length; i++) {
            if (count[i] >= k) reportedList.add(id_list[i]);
        }
        
        int[] answer = new int[id_list.length];
        for (int i = 0; i < id_list.length; i++) {
            Set<String> set = reportInfo.get(id_list[i]);
            for (String s : reportedList) {
                if (set.contains(s)) answer[i]++;
            }
        }
        
        return answer;
    }
}