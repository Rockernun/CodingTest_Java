class Solution {
    
    int count = 0;
    
    public int solution(int[] numbers, int target) {
        dfs(0, numbers, target, 0);
        return count;
    }
    
    private void dfs(int depth, int[] numbers, int target, int sum) {
        if (depth == numbers.length && sum == target) {
            count++;
            return;
        }
        
        if (depth == numbers.length) {
            return;
        }
        
        dfs(depth + 1, numbers, target, sum + numbers[depth]);
        dfs(depth + 1, numbers, target, sum - numbers[depth]);
    }
}