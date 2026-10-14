import java.util.Arrays;

class Solution {
    public String solution(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        StringBuilder sb = new StringBuilder();

        for (int n = 0; n < numbers.length; n++) {
            strNumbers[n] = String.valueOf(numbers[n]);
        }
        
        Arrays.sort(strNumbers, (a, b) -> (b + a).compareTo(a + b));
        
        for (int n = 0; n < strNumbers.length; n++) {
            sb.append(strNumbers[n]);
        }
        
        if (sb.toString().charAt(0) == '0') return "0";
        return sb.toString();
    }
}