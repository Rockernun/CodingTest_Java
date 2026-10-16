import java.util.Set;
import java.util.HashSet;

class Solution {
    
    boolean[] visited;
    Set<Integer> count;
    StringBuilder sb;
    
    public int solution(String numbers) {
        int n = numbers.length();
        String[] splitNumbers = numbers.split("");
        visited = new boolean[n];
        count = new HashSet<>();
        sb = new StringBuilder();
        dfs(splitNumbers);
        
        return count.size();
    }
    
    private void dfs(String[] numbers) {
        if (sb.length() != 0) {
            int currentNumber = Integer.parseInt(sb.toString());
            if (isPrimeNumber(currentNumber)) count.add(currentNumber);
        }
        
        for (int i = 0; i < numbers.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            sb.append(numbers[i]);
            dfs(numbers);
            visited[i] = false;
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    
    private boolean isPrimeNumber(int number) {
        if (number < 2) return false;
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }
        
        return true;
    }
}