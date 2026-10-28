import java.util.*;

class Solution {

    List<String> answer;

    public String[] solution(String[] orders, int[] course) {
        answer = new ArrayList<>();

        for (int i = 0; i < course.length; i++) {
            findMostOrderedCombination(orders, course[i]);
        }

        Collections.sort(answer);
        String[] answerArr = new String[answer.size()];
        for (int i = 0; i < answer.size(); i++) {
            answerArr[i] = answer.get(i);
        }

        return answerArr;
    }

    private void findMostOrderedCombination(String[] orders, int choice) {
        Map<String, Integer> orderedInfo = new HashMap<>();

        for (String order : orders) {
            List<Character> menus = new ArrayList<>();
            for (char m : order.toCharArray()) menus.add(m);
            Collections.sort(menus);

            List<List<Character>> combinationList = combination(menus, choice);
            for (List<Character> c : combinationList) {
                StringBuilder sb = new StringBuilder();
                for (char m : c) sb.append(m);
                String key = sb.toString();
                orderedInfo.put(key, orderedInfo.getOrDefault(key, 0) + 1);
            }
        }

        int maxInclude = 0;
        for (int include : orderedInfo.values()) {
            maxInclude = Math.max(maxInclude, include);
        }

        if (maxInclude < 2) return;  

        for (String key : orderedInfo.keySet()) {
            if (orderedInfo.get(key) == maxInclude) answer.add(key); 
        }
    }

    private List<List<Character>> combination(List<Character> list, int choice) {
        List<List<Character>> result = new ArrayList<>();
        int n = list.size();

        for (int mask = 0; mask < (1 << n); mask++) {
            if (Integer.bitCount(mask) != choice) continue;

            List<Character> picked = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (((mask >> i) & 1) == 1) picked.add(list.get(i));
            }

            result.add(picked);
        }

        return result;
    }
}