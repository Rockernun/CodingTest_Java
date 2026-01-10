import java.util.HashMap;
import java.util.Map;

class Solution {
    public static String solution(String[] participant, String[] completion) {
        Map<String, Integer> map = new HashMap<>();

        for (String s : completion) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        for (String s : participant) {
            if (map.getOrDefault(s, 0) == 0) {
                return s;
            }
            
            map.put(s, map.getOrDefault(s, 0) - 1);
        }
        
        return null;
    }
}