import java.util.*;

class Solution {
    Set<Set<String>> results = new HashSet<>();

    public int solution(String[] user_id, String[] banned_id) {
        Map<String, List<String>> candidateInfo = new HashMap<>();

        for (int i = 0; i < banned_id.length; i++) {
            List<String> candidates = new ArrayList<>();

            for (String user : user_id) {
                if (matches(user, banned_id[i])) {
                    candidates.add(user);
                }
            }

            candidateInfo.put(String.valueOf(i), candidates);
        }

        backtrack(0, banned_id.length, candidateInfo, new HashSet<>());

        return results.size();
    }

    private void backtrack(int idx, int total, Map<String, List<String>> candidateInfo, Set<String> chosen) {
        if (idx == total) {
            results.add(new HashSet<>(chosen));
            return;
        }

        for (String user : candidateInfo.get(String.valueOf(idx))) {
            if (chosen.contains(user)) { 
                continue;
            }

            chosen.add(user);
            backtrack(idx + 1, total, candidateInfo, chosen);
            chosen.remove(user);
        }
    }

    private boolean matches(String user, String banned) {
        if (user.length() != banned.length()) {
            return false;
        }

        for (int j = 0; j < user.length(); j++) {
            if (banned.charAt(j) != '*') {
                if (user.charAt(j) != banned.charAt(j)) {
                    return false;
                }
            }
        }

        return true;
    }
}