// 하나의 큐에서 하나 뽑아서 다른 큐에 넣음(이 작업을 1번이라고 설정)
// 최소 몇 번을 해야 두 큐의 원소의 합이 같아지는가?
import java.util.Deque;
import java.util.ArrayDeque;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;
        int maxCount = queue1.length * 3;
        // 두 큐의 모든 원소의 합을 일단 구함
        long sum1 = 0;
        long sum2 = 0;
        for (int i = 0; i < queue1.length; i++) {
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        // 만약 sum1 + sum2가 홀수이면 합을 같게 할 수 없음
        if ((sum1 + sum2) % 2 == 1) {
            return -1;
        }
        
        // 하나의 원소가 sum1 + sum2 / 2보다 큰 경우 -1 반환
        for (int i = 0; i < queue1.length; i++) {
            long middle = (sum1 + sum2) / 2;
            if (queue1[i] > middle || queue2[i] > middle) {
                return -1;
            }
        }
        
        Deque<Integer> deque1 = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        
        for (int i = 0; i < queue1.length; i++) {
            deque1.offer(queue1[i]);
            deque2.offer(queue2[i]);
        }
        
        // 두 큐의 원소들의 합이 같지 않을 동안
        while (sum1 != sum2 && answer <= maxCount) {
            // 합이 더 큰 큐에서 하나 뺴서 다른 큐에 집어 넣고 answer를 1만큼 증가
            if (sum1 > sum2) {
                int poll = deque1.poll();
                deque2.offer(poll);
                sum1 -= poll;
                sum2 += poll;
                answer++;
            } else if (sum1 < sum2) {
                int poll = deque2.poll();
                deque1.offer(poll);
                sum1 += poll;
                sum2 -= poll;
                answer++;
            }
        }
        return (sum1 != sum2) ? -1 : answer;
    }
}