import java.util.List;
import java.util.ArrayList;
import java.lang.StringBuilder;

class Solution {
    
    static long answer = 0L;
    static char[][] combinations = {
        {'+', '-', '*'}, {'+', '*', '-'},
        {'-', '+', '*'}, {'-', '*', '+'},
        {'*', '+', '-'}, {'*', '-', '+'}
    };
    
    public long solution(String expression) {
        List<Long> operands = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        
        StringBuilder sb = new StringBuilder();
        for (char c : expression.toCharArray()) {
            if (Character.isDigit(c)) {
                sb.append(c);
            } else {
                operands.add(Long.parseLong(sb.toString()));
                sb.setLength(0);
                operators.add(c);
            }
        }
        
        operands.add(Long.parseLong(sb.toString()));
        
        for (int i = 0; i < combinations.length; i++) { 
            char[] combination = combinations[i]; 
            List<Long> copyOperands = new ArrayList<>(operands);
            List<Character> copyOperators = new ArrayList<>(operators);
            
            for (int j = 0; j < 3; j++) {
                char currentOperator = combination[j];
                
                int k = 0;
                while (k < copyOperators.size()) {
                    if (currentOperator == copyOperators.get(k)) {
                        long result = 0L;
                        if (currentOperator == '+') {
                            result = copyOperands.get(k) + copyOperands.get(k + 1);
                        } else if (currentOperator == '-') {
                            result = copyOperands.get(k) - copyOperands.get(k + 1);
                        } else {
                            result = copyOperands.get(k) * copyOperands.get(k + 1);
                        }
                        
                        copyOperators.remove(k);
                        copyOperands.set(k, result);
                        copyOperands.remove(k + 1);
                    } else {
                        k++;
                    }
                }
            }
            
            answer = Math.max(answer, Math.abs(copyOperands.get(0)));
        }
        
        return answer;
    }
}