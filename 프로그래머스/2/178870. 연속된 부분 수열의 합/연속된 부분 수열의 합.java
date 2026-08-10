class Solution {
    public int[] solution(int[] sequence, int k) {
        // left, right 포인터 모두 첫 번째 인덱스부터 시작해서 늘리자
        int[] answer = new int[]{0, sequence.length - 1};
        int left = 0;
        int right = 0;
        int sum = 0;
        
        // 오른쪽 포인터가 배열의 마지막 인덱스일 동안 반복
        while (right < sequence.length) {
            sum += sequence[right];
            
            while (left <= right && sum > k) {
                sum -= sequence[left];
                left++;
            }  
            
            if (sum == k) {
                // 저장된 정답 후보의 길이와 같은데 시작 지점이 더 앞쪽이면 교체
                if (((answer[1] - answer[0]) == right - left) && (answer[0] > left)) {
                    answer[0] = left;
                    answer[1] = right;
                }
                
                // 저장된 정답 후보의 길이보다 작으면 교체
                if ((answer[1] - answer[0]) > (right - left)) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }
            right++;
            
        }
        return answer;
    }
}