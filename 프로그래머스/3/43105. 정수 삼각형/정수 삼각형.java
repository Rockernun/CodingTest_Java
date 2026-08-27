class Solution {
    public int solution(int[][] triangle) {
        if (triangle.length == 1) {
            return triangle[0][0];
        }
        
        for (int i = 1; i < triangle.length; i++) {
            // 왼쪽 끝에 있는 값은 이전 행에서의 왼쪽 끝 값을, 오른쪽 끝에 있는 값은 이전 행에서의 오른쪽 끝 값을 누적
            for (int j = 0; j < triangle[i].length; j++) {
                if (j == 0) {
                    triangle[i][0] += triangle[i - 1][0];
                } else if (j == triangle[i].length - 1) {
                    triangle[i][triangle[i].length - 1] += triangle[i - 1][triangle[i - 1].length - 1];
                } else {
                    // 사이에 낀 값은 이전 행에서의 왼쪽, 오른쪽 값 중 더 큰 값을 누적
                    triangle[i][j] += Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                }
            }  
        }
        
        int answer = 0;
        for (int max : triangle[triangle.length - 1]) {
            if (max > answer) {
                answer = max;
            }
        }
        return answer;
    }
}