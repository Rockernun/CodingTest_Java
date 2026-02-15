import java.util.List;
import java.util.ArrayList;

class Solution {
    
    static class Student {
        int number;
        int[] pattern;
        int answerCount;
        
        public Student(int number, int[] pattern) {
            this.number = number;
            this.pattern = pattern;
        }
        
        public int getStudentNumber() {
            return number;
        }
        
        public int[] getPattern() {
            return pattern;
        }
        
        public int getPatternLength() {
            return pattern.length;
        }
        
        public int getAnswerCount() {
            return answerCount;
        }
    }
    
    public int[] solution(int[] answers) {
        Student student1 = new Student(1, new int[]{1, 2, 3, 4, 5});
        Student student2 = new Student(2, new int[]{2, 1, 2, 3, 2, 4, 2, 5});
        Student student3 = new Student(3, new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
        
        for (int i = 0; i < answers.length; i++) {
            if (student1.getPattern()[i % student1.getPatternLength()] == answers[i]) {
                student1.answerCount++;
            }
            
            if (student2.getPattern()[i % student2.getPatternLength()] == answers[i]) {
                student2.answerCount++;
            }
            
            if (student3.getPattern()[i % student3.getPatternLength()] == answers[i]) {
                student3.answerCount++;
            }
        }
        
        Student[] students = {student1, student2, student3};
        List<Integer> result = new ArrayList<>();
        int max = 0;
        
        for (Student student : students) {
            if (student.answerCount > max) {
                max = student.answerCount;
            }
        }
        
        for (Student student : students) {
            if (max == student.answerCount) {
                result.add(student.number);
            }
        }
        
        int[] winners = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            winners[i] = result.get(i);
        }
        
        return winners;
    }
}