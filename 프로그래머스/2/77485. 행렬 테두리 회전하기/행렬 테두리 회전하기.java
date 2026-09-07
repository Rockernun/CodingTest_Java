class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        // 행렬 초기화
        int[][] grid = new int[rows][columns];
        int[] answer = new int[queries.length];
        
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                grid[i][j] = i * columns + (j + 1);
            }
        }
    
        // [[2,2,5,4], [3,3,6,6], [5,1,6,3]]
        for (int i = 0; i < queries.length; i++) { 
            int leftTopRow = queries[i][0] - 1;
            int leftTopCol = queries[i][1] - 1;
            int rightBottomRow = queries[i][2] - 1;
            int rightBottomCol = queries[i][3] - 1;
            
            int temp = grid[leftTopRow][leftTopCol];
            int min = temp;
            
            // 왼쪽 변은 위로 끌어올림
            for (int j = leftTopRow; j < rightBottomRow; j++) {
                grid[j][leftTopCol] = grid[j + 1][leftTopCol];
                min = Math.min(min, grid[j][leftTopCol]);
            }
            
            // 아래쪽 변은 왼쪽으로 밈
            for (int j = leftTopCol; j < rightBottomCol; j++) {
                grid[rightBottomRow][j] = grid[rightBottomRow][j + 1];
                min = Math.min(min, grid[rightBottomRow][j]);
            }
            
            // 오른쪽 변은 아래로 내림
            for (int j = rightBottomRow; j > leftTopRow; j--) {
                grid[j][rightBottomCol] = grid[j - 1][rightBottomCol];
                min = Math.min(min, grid[j][rightBottomCol]);
            }
            
            // 위쪽 변은 오른쪽으로 밈
            for (int j = rightBottomCol; j > leftTopCol; j--) {
                grid[leftTopRow][j] = grid[leftTopRow][j - 1];
                min = Math.min(min, grid[leftTopRow][j]);
            }
            
            grid[leftTopRow][leftTopCol + 1] = temp;
            answer[i] = min;
        }
        
        return answer;
    }
}