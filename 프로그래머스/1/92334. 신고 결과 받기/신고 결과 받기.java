import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public static int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> map = new HashMap<>();
        Map<String, Integer> reportedUsers = new HashMap<>();
        List<String> suspendedUsers = new ArrayList<>();
        List<Integer> result = new ArrayList<>();

        for (String s : id_list) {
            map.putIfAbsent(s, new HashSet<>());
        }

        for (String s : report) {
            String[] split = s.split(" ");
            map.get(split[0]).add(split[1]);
        }

        for (String s : map.keySet()) {  
            for (String user : map.get(s)) { 
                reportedUsers.put(user, reportedUsers.getOrDefault(user, 0) + 1);
            }
        }

        for (String s : reportedUsers.keySet()) {
            if (reportedUsers.get(s) >= k) {
                suspendedUsers.add(s);
            }
        }

        for (String s : id_list) {
            int count = 0;
            for (String user : map.get(s)) {
                if (suspendedUsers.contains(user)) {
                    count++;
                }
            }
            result.add(count);
        }

        return result.stream().mapToInt(i -> i).toArray();
    }
}