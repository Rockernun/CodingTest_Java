import java.util.Arrays;

class Solution {
    public int solution(int[][] sizes) {
        int maxHeight = 0;
        int maxWidth = 0;
        
        for (int[] size : sizes) {
            Arrays.sort(size);
        }
        
        for (int i = 0; i < sizes.length; i++) {
            if (sizes[i][0] > maxHeight) {
                maxHeight = sizes[i][0];
            }
            
            if (sizes[i][1] > maxWidth) {
                maxWidth = sizes[i][1];
            }
        }
        
        return maxHeight * maxWidth;
    }
}