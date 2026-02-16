import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        // yellow의 곱셈쌍을 모두 구함
        List<List<Integer>> divisorPairs = new ArrayList<>();
        
        for (int i = 1; i <= yellow; i++) {   
            if (yellow % i == 0) {
                divisorPairs.add(List.of(yellow / i, i));
            }
        }
        
        // 곱셈쌍 (가로, 세로)를 (가로 + 2) * (세로 + 2) - yellow 개수 = brown이면 
        for (List<Integer> divisorPair : divisorPairs) {
            if ((divisorPair.get(0) + 2) * (divisorPair.get(1) + 2) - yellow == brown) {
                answer[0] = divisorPair.get(0) + 2;
                answer[1] = divisorPair.get(1) + 2;
                break;
            }
        }
        
        // 그때의 (가로 + 2, 세로 + 2)를 int[] 배열로 반환
        return answer;
    }
}