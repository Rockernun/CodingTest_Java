import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[] solution(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int i = 0; i < numbers.length - 1; i++) {
            for(int j = i + 1; j < numbers.length; j++) {
                list.add(numbers[i] + numbers[j]);
            }
        }
        Integer[] answer = list.stream().distinct().toArray(Integer[]::new);
        Arrays.sort(answer);
        
        return Arrays.stream(answer).mapToInt(Integer::intValue).toArray();
    }
}