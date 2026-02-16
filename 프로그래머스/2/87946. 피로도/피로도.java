class Solution {
    
    private int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        calculateDungeons(dungeons, 0, k);
        return answer;
    }
    
    private void calculateDungeons(int[][] arr, int depth, int k) {
        int count = 0;
        if (depth == arr.length) {
            for (int[] dungeonInfo : arr) {
                if (k >= dungeonInfo[0]) {
                    k -= dungeonInfo[1];
                    count++;
                } else {
                    break;
                }
            }
            
            answer = Math.max(answer, count);
        }
        
        for (int i = depth; i < arr.length; i++) {
            swap(arr, depth, i);
            calculateDungeons(arr, depth + 1, k);
            swap(arr, depth, i); 
        }
    }
    
    private void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}