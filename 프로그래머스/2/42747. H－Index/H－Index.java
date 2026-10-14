import java.util.Arrays;

class Solution {
    public int solution(int[] citations) {
        int h = 0;
        
        while (true) {
            int count = 0;
            
            for (int i = 0; i < citations.length; i++) {
                if (citations[i] >= h) count++;
            }
            
            if (count < h) break;
            h++;
        }
        
        return h - 1;
    }
}