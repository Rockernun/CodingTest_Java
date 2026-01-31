import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String answer = "";
        String[] numberToStringArray = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numberToStringArray[i] = numbers[i] + "";
        }
        
        Arrays.sort(numberToStringArray, (s1, s2) -> (s2 + s1).compareTo(s1 + s2));
        for (String s : numberToStringArray) {
            answer += s;
        }
        
        if (numberToStringArray[0].equals("0")) {
            return "0";
        }
        
        return answer;
    }
}