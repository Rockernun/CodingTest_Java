import java.util.ArrayList;

class Solution {
    public int[] solution(int[] answers) {
        int[][] patterns = {
            {1, 2, 3, 4, 5},
            {2, 1, 2, 3, 2, 4, 2, 5},
            {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };

        int[] score = new int[patterns.length]; 
        
        for(int i = 0; i < answers.length; i++) {
            for(int j = 0; j < patterns.length; j++) {
                int user_answer = patterns[j][i % patterns[j].length];
                if(answers[i] == user_answer) {
                    score[j]++;
                }
            }
        }
        
        int maxScore = Math.max(score[0], Math.max(score[1], score[2]));
        
        ArrayList<Integer> correctList = new ArrayList<>();
        for (int i = 0; i < score.length; i++) {
            if (score[i] == maxScore) {
                correctList.add(i + 1);
            }
        }
        
        return correctList.stream().mapToInt(Integer::intValue).toArray();
    }
}