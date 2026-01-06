import java.util.ArrayDeque;

class Solution {
    boolean solution(String input) {
        ArrayDeque<Character> brackets = new ArrayDeque<>();

        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == '(') {
                brackets.push('(');
            }

            if (input.charAt(i) == ')') {
                if (brackets.isEmpty()) {
                    return false;
                }
                brackets.pop();
            }
        }
    
        return brackets.isEmpty();
    }
}