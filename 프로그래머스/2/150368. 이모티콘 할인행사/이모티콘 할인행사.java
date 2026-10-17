class Solution {
    
    int plus = 0;
    int total = 0;
    int[] output;
    int[] ratio = {40, 30, 20, 10};
    
    public int[] solution(int[][] users, int[] emoticons) {
        output = new int[emoticons.length];
        findEmoticonsDiscountRates(users, emoticons, 0, emoticons.length);
        
        return new int[]{plus, total};
    }
    
    private void findEmoticonsDiscountRates(int[][] users, int[] emoticons, int depth, int n) {
        if (depth == n) {
            calculate(users, emoticons);
            return;
        }
        
        for (int i = 0; i < ratio.length; i++) {
            output[depth] = ratio[i];
            findEmoticonsDiscountRates(users, emoticons, depth + 1, n);
        }
    }

    private void calculate(int[][] users, int[] emoticons) {
        int totalPurchasedAmount = 0;
        int emoticonsPlus = 0;
        for (int[] user : users) {
            int sum = 0;
            for (int e = 0; e < emoticons.length; e++) {
                if (sum >= user[1]) {
                    emoticonsPlus++;
                    break;
                }
                
                if (output[e] >= user[0]) sum += (emoticons[e] / 100 * (100 - output[e]));
                
                if (e == emoticons.length - 1 && sum >= user[1]) emoticonsPlus++;
                if (e == emoticons.length - 1 && sum < user[1]) totalPurchasedAmount += sum;
            }
        }
        
        if (plus < emoticonsPlus) {
            plus = emoticonsPlus;
            total = totalPurchasedAmount;
        }
        
        if (plus == emoticonsPlus && total < totalPurchasedAmount) total = totalPurchasedAmount;
    }
}