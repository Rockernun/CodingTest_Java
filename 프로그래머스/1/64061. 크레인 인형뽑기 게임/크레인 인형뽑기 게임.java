import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

class Solution {
    public static int solution(int[][] board, int[] moves) {
        Map<Integer, Stack<Integer>> pickDollMachine = new HashMap<>();
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board[i].length; j++) {
                pickDollMachine.putIfAbsent(j + 1, new Stack<>());
                if (board[i][j] != 0) {
                    pickDollMachine.get(j + 1).push(board[i][j]);
                }
            }
        }

        Stack<Integer> result = new Stack<>();
        int removedDollCount = 0;

        for (int move : moves) {
            Stack<Integer> dolls = pickDollMachine.get(move);
            if (dolls.isEmpty()) {
                continue;
            }

            Integer pickedDoll = dolls.pop();
            if (!result.isEmpty() && result.peek().equals(pickedDoll)) {
                result.pop();
                removedDollCount += 2;
            } else {
                result.push(pickedDoll);
            }
        }

        return removedDollCount;
    }
}