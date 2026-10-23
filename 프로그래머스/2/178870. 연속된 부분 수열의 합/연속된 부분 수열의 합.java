class Solution {
    public int[] solution(int[] sequence, int k) {
        int n = sequence.length;
        int[] prefix = new int[n + 1];
        for (int i = 0; i < n; i++) prefix[i + 1] = prefix[i] + sequence[i];

        int left = 0;
        int bestL = 0, bestR = n;                    
        for (int right = 0; right < n; right++) {     
            while (prefix[right + 1] - prefix[left] > k) left++; 
            if (prefix[right + 1] - prefix[left] == k && right - left < bestR - bestL) {
                bestL = left;
                bestR = right;
            }
        }
        return new int[]{bestL, bestR};
    }   
}