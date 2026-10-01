import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> count = new HashMap<>();
        for (int t : tangerine) {
            count.put(t, count.getOrDefault(t, 0) + 1);
        }
        
        List<Integer> counts = new ArrayList<>(count.values());
        counts.sort(Collections.reverseOrder());
        int answer = 0;
        int result = 0;
        
        // 각 크기의 귤을 보면서
        for (int i = 0; i < counts.size(); i++) {
            if (counts.get(i) >= k - result) {  // 할당량을 같거나 넘는다면
                answer = i + 1;
                break;
            }
            
            result += counts.get(i);
        }
        
        return answer;
    }
}