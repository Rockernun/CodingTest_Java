import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        Map<String, Set<String>> reportedBy = new HashMap<>();
        for (String r : report) {
            String[] p = r.split(" ");
            reportedBy.computeIfAbsent(p[1], x -> new HashSet<>()).add(p[0]);
        }

        Map<String, Integer> idx = new HashMap<>();
        for (int i = 0; i < id_list.length; i++) idx.put(id_list[i], i);

        int[] answer = new int[id_list.length];
        for (Set<String> reporters : reportedBy.values()) {
            if (reporters.size() >= k) {
                for (String u : reporters) answer[idx.get(u)]++;
            }
        }
        return answer;
    }
}