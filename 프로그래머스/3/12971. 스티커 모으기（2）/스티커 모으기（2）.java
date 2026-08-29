class Solution {
    
    public int solution(int sticker[]) {
        int[] dp1 = new int[sticker.length - 1];
        int[] dp2 = new int[sticker.length];
        
        if (sticker.length == 1) {
            return sticker[0];
        } 
        
        if (sticker.length == 2) {
            return Math.max(sticker[0], sticker[1]);
        }
        
        // 첫 번째 원소를 포함하는 원형 스티커
        dp1[0] = sticker[0];
        dp1[1] = Math.max(sticker[0], sticker[1]);
        for (int i = 2; i < sticker.length - 1; i++) {
            dp1[i] = Math.max(sticker[i] + dp1[i - 2], dp1[i - 1]);
        }
        
        // 마지막 원소를 포함하는 원형 스티커
        dp2[1] = sticker[1];
        dp2[2] = Math.max(sticker[1], sticker[2]);
        for (int i = 3; i < sticker.length; i++) {
            dp2[i] = Math.max(sticker[i] + dp2[i - 2], dp2[i - 1]);
        }
        
        return Math.max(dp1[sticker.length - 2], dp2[sticker.length - 1]);
    }
}