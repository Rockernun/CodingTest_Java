import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    boolean solution(String s) {
        Deque<Character> stack = new ArrayDeque<>();
    
        if (s.charAt(0) == ')') return false;
        stack.push(s.charAt(0));
        
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty() && stack.peekLast() == '(' && s.charAt(i) == ')') {
                stack.pop();
            } else if (stack.isEmpty()) {
                if (s.charAt(i) == ')') return false;
                stack.push(s.charAt(i));
            } else {
                stack.push(s.charAt(i));
            }
        }
        
        return stack.isEmpty();
    }
}