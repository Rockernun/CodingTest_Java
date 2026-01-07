import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

class Solution {
    public static int solution(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        int result = 0;

        for (int i = 0; i < s.length(); i++) {
            deque.addLast(s.charAt(i));
        }

        for (int i = 0; i < s.length(); i++) {
            if (isRightBrackets(deque)) {
                result++;
            }

            deque.addLast(deque.removeFirst());
        }

        return result;
    }

    private static boolean isRightBrackets(Deque<Character> deque) {
        Stack<Character> stack = new Stack<>();

        for (Character c : deque) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }

                Character stackPeekItem = stack.pop();
                if (c == ')' && stackPeekItem != '(' || c == '}' && stackPeekItem != '{' || c == ']' && stackPeekItem != '[') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}