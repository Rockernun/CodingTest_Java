import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<String> solution(String[] orders, int[] course) {

        List<String> result = new ArrayList<>();

        for (int i : course) {
            Map<String, Integer> map = new HashMap<>();
            for (String order : orders) {
                for (String s : makeCombinations(order, i)) {
                    map.put(s, map.getOrDefault(s, 0) + 1);
                }
            }

            int max = 0;
            for (int count : map.values()) {
                if (count > max)  {
                    max = count;
                }
            }
            
            if (max >= 2) {
                for (Map.Entry<String, Integer> e : map.entrySet()) {
                    if (e.getValue() == max) {
                        result.add(e.getKey());
                    }
                }
            }
        }

        Collections.sort(result);
        return result;

    }

    private static List<String> makeCombinations(String order, int numberOfDishes) {
        char[] menus = order.toCharArray();
        Arrays.sort(menus);
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(menus, numberOfDishes, 0, sb, result);
        return result;
    }

    private static void dfs(char[] menus, int numberOfDishes, int start, StringBuilder sb, List<String> result) {
        if (sb.length() == numberOfDishes) {
            result.add(sb.toString());
            return;
        }

        for (int i = start; i < menus.length; i++) {
            sb.append(menus[i]);
            dfs(menus, numberOfDishes, i + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}