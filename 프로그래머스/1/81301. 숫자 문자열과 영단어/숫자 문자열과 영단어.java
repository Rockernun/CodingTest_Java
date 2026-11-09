import java.util.Map;

class Solution {
    
    Map<String, Character> number = Map.of(
        "zero", '0', "one", '1', "two", '2', "three", '3', "four", '4',
        "five", '5', "six", '6', "seven", '7', "eight", '8', "nine", '9'
    ); 
    
    public int solution(String s) {
        StringBuilder answer = new StringBuilder();
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                answer.append(c);
                continue;
            }
            
            sb.append(c);
            
            if (number.containsKey(sb.toString())) { 
                answer.append(number.get(sb.toString()));
                sb.setLength(0);
            }
        }
        
        return Integer.parseInt(answer.toString());
    }
}