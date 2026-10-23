class Solution {
    public int solution(int[] topping) {
        // 토핑은 총 1만가지가 있을 수 있다.
        int answer = 0;
        int[] toppingKind = new int[10001];
        int rightKind = 0;
        
        for (int t : topping) {
            if (toppingKind[t] == 0) rightKind++;
            toppingKind[t]++;
        }
        
        boolean[] rest = new boolean[10001];
        int leftKind = 0;
        for (int i = 0; i < topping.length - 1; i++) {
            if (!rest[topping[i]]) {
                leftKind++;
                rest[topping[i]] = true;
            }
            
            toppingKind[topping[i]]--;
            if (toppingKind[topping[i]] == 0) rightKind--;
            if (leftKind == rightKind) answer++;
        }
        
        return answer;
    }
}