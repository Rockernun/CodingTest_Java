import java.util.*;

class Solution {
    
    static Set<Integer> outputSet;
    static boolean[] visited;
    static StringBuilder sb;
    
    public int solution(String numbers) {
        outputSet = new HashSet<>();
        List<Character> numberList = new ArrayList<>();
        
        // 한 자리 숫자들을 삽입한 numberList
        for (int i = 0; i < numbers.length(); i++) {
            numberList.add(numbers.charAt(i));
        }
        
        // 소수인지 판별하고 순열을 실행하면서 파싱한 결과를 outputSet에 삽입한다.
        for (int i = 1; i <= numberList.size(); i++) {
            visited = new boolean[numberList.size()];
            permutation(new ArrayList<>(), i, numberList);
        }
        
        return outputSet.size();
    }
    
    private void permutation(List<Character> current, int r, List<Character> numberList) {
        if (current.size() == r) {
            sb = new StringBuilder();
            
            for (int i = 0; i < current.size(); i++) {
                sb.append(current.get(i));
            }
            
            if (isPrime(Integer.parseInt(sb.toString()))) {
                outputSet.add(Integer.parseInt(sb.toString()));
            }
            
            return;
        }
        
        for (int i = 0; i < numberList.size(); i++) {
            if (!visited[i]) {
                current.add(numberList.get(i));
                visited[i] = true;
                permutation(current, r, numberList);
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