import java.util.Arrays;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        
        for (int c = 0; c < commands.length; c++) {
            int[] copiedArr = Arrays.copyOfRange(array, commands[c][0] - 1, commands[c][1]);
            Arrays.sort(copiedArr);
            answer[c] = copiedArr[commands[c][2] - 1];
        }
        
        return answer;
    }
}