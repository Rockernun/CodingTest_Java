import java.util.*;

class Solution {
    
    Set<Integer> output;
    List<Character> charList;
    boolean[] visited;
    StringBuilder sb;
    
    public int solution(String numbers) {
        
        charList = new ArrayList<>();
        output = new HashSet<>();
        
        for (int i = 0; i < numbers.length(); i++) {
            charList.add(numbers.charAt(i));
        }
        
        for (int i = 1; i < charList.size() + 1; i++) {
            visited = new boolean[charList.size()];
            permutation(new ArrayList<>(), i, charList);
        }
        
        return output.size();
    }
    
    private void permutation(List<Character> current, int r, List<Character> charList) {
        
        if (current.size() == r) {
            sb = new StringBuilder();
            
            for (int i = 0; i < current.size(); i++) {
                sb.append(current.get(i));
            }
            
            if (isPrime(Integer.parseInt(sb.toString()))) {
                output.add(Integer.parseInt(sb.toString()));
            }
            
            return;
        }
        
        for (int i = 0; i < charList.size(); i++) {
            if (!visited[i]) {
                current.add(charList.get(i));
                visited[i] = true;
                permutation(current, r, charList);
                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
    
    // 소수 판별 메서드
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i * i <= number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}