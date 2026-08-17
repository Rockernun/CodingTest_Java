// 특정 범위의 물건들을 전부 구매
// 모든 종류의 보석을 하나씩 포함하는 가장 짧은 범위만...
// 시작 진열대 번호와 끝 진열대 번호를 반환(범위가 여러 개라면 시작 진열대 번호가 작은 것)
import java.util.*;

class Solution {
    
    Set<String> gemInfo = new HashSet<>();
    List<int[]> rangeInfo = new ArrayList<>();
    
    public int[] solution(String[] gems) {
        for (String gem : gems) {
            gemInfo.add(gem);
        }
        
        if (gems.length == 1 || gemInfo.size() == 1) {
            return new int[]{1, 1};
        }
        
        int left = 0;
        int right = 0;
        
        Map<String, Integer> gemCount = new HashMap<>();
        
        while (right < gems.length) {
            // 오른쪽 보석을 추가
            gemCount.put(gems[right], gemCount.getOrDefault(gems[right], 0) + 1);
            
            // 모든 종류의 보석이 포함되어 있는 동안 왼쪽 보석을 하나씩 빼기
            while (gemInfo.size() == gemCount.size()) {
                rangeInfo.add(new int[]{left + 1, right + 1});
                
                gemCount.put(gems[left], gemCount.get(gems[left]) - 1);
                
                if (gemCount.get(gems[left]) == 0) {
                    gemCount.remove(gems[left]);
                }
                
                left++;
            }
            
            right++;
        }
        
        int[] answer = rangeInfo.get(0);
        
        for (int i = 1; i < rangeInfo.size(); i++) {
            int[] current = rangeInfo.get(i);
            if ((answer[1] - answer[0]) > (current[1] - current[0])) {
                answer[0] = current[0];
                answer[1] = current[1];
            } else if ((answer[1] - answer[0] == (current[1] - current[0]))) {
                if (answer[0] > current[0]) {
                    answer[0] = current[0];
                    answer[1] = current[1];
                }
            }
        }
        return answer;
    }
}