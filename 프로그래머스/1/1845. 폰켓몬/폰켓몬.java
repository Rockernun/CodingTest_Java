import java.util.HashMap;
import java.util.Map;

class Solution {
    public int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        int count = nums.length / 2;
        
        if (map.keySet().size() >= count) {
            return count;
        } else {
            return map.keySet().size();
        }
    }
}