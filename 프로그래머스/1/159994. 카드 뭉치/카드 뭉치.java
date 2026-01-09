import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public static String solution(String[] cards1, String[] cards2, String[] goal) {

        Deque<String> deque1 = new ArrayDeque<>();
        Deque<String> deque2 = new ArrayDeque<>();

        for (String s : cards1) {
            deque1.addLast(s);
        }

        for (String s : cards2) {
            deque2.addLast(s);
        }

        for (String s : goal) {
            if (!deque1.isEmpty() && !deque2.isEmpty()) {
                if (!s.equals(deque1.peekFirst()) && !s.equals(deque2.peekFirst())) {
                    return "No";
                }
            }
            
            if (!deque1.isEmpty() && deque2.isEmpty()) {
                if (!s.equals(deque1.peekFirst())) {
                    return "No";
                }
            }
            
            if (!deque2.isEmpty() && deque1.isEmpty()) {
                if (!s.equals(deque2.peekFirst())) {
                    return "No";
                }
            }
            
            if (!deque1.isEmpty() && deque1.peek().equals(s)) {
                deque1.removeFirst();
            }
            
            if (!deque2.isEmpty() && deque2.peek().equals(s)) {
                deque2.removeFirst();
            }
        }

        return "Yes";
    }
}
