class Solution {
    public int solution(int[] wallet, int[] bill) {
        int answer = 0;
        
        int x = bill[0];
        int y = bill[1];
        
        Integer minBill = Math.min(x, y);
        Integer maxBill = Math.max(x, y);
        int minWallet = Math.min(wallet[0], wallet[1]);
        int maxWallet = Math.max(wallet[0], wallet[1]);
        
        while (Math.min(x, y) > minWallet || Math.max(x, y) > maxWallet) {
            if (x > y) {
                x = (int) Math.floor(x / 2);
            } else {
                y = (int) Math.floor(y / 2);
            }
            
            answer++;
        }
        
        return answer;
    }
}