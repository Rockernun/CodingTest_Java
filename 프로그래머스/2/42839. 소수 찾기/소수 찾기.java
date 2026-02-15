import java.util.Set;
import java.util.HashSet;

class Solution {
    
    public int solution(String numbers) {
        Set<Integer> makeAllPermutations = permutations(numbers);
        int answer = 0;
        
        for (Integer eachPermutation : makeAllPermutations) {
            if (isPrime(eachPermutation)) {
                answer++;
            }
        }
        
        return answer;
    }
    
    private Set<Integer> permutations(String numbers) {
        char[] individualNumbers = numbers.toCharArray();
        boolean[] visited = new boolean[individualNumbers.length];
        Set<Integer> result = new HashSet<>();
        
        for (int r = 1; r <= individualNumbers.length; r++) {
            dfs(individualNumbers, visited, new StringBuilder(), r, result);
        }
        
        return result;
    }
    
    private void dfs(char[] individualNumbers, boolean[] visited, StringBuilder current, int r, Set<Integer> result) {
        if (current.length() == r) {
            result.add(Integer.parseInt(current.toString()));
            return;
        }

        for (int i = 0; i < individualNumbers.length; i++) {
            if (visited[i]) {
                continue;
            }

            visited[i] = true;
            current.append(individualNumbers[i]);

            dfs(individualNumbers, visited, current, r, result);

            current.deleteCharAt(current.length() - 1);
            visited[i] = false;
        }
    }
    
    private boolean isPrime(int n) {
        if (n < 2) {
            return false;
        } else if (n == 2) {
            return true;
        } else if (n % 2 == 0) {
            return false;
        }

        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}