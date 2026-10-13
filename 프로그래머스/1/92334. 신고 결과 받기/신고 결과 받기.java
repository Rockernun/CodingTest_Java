import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map1 = new HashMap<>();
        Map<String, Integer> map2 = new HashMap<>();
        int[] answer = new int[id_list.length];
        
        for (String id : id_list) {
            map1.put(id, new HashSet<>());
            map2.put(id, 0);
        }
        
        for (String s : report) {
            String[] split = s.split(" ");
            map1.get(split[0]).add(split[1]);
        }
        
        for (String s1 : map2.keySet()) {
            for (String s2 : map1.get(s1)) {
                map2.put(s2, map2.get(s2) + 1);
            }
        }
        
        List<String> reportedUsers = new ArrayList<>();
        
        for (String user : map2.keySet()) {
            if (map2.get(user) >= k) {
                reportedUsers.add(user);
            }
        }
        
        for (int i = 0; i < id_list.length; i++) {
            int count = 0;
            for (String reportedUser : reportedUsers) {
                if (map1.get(id_list[i]).contains(reportedUser)) count++;
            }
            
            answer[i] = count;
        }
        
        return answer;
    }
}