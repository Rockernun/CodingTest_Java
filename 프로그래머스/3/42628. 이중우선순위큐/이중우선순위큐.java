import java.util.PriorityQueue;
import java.util.Collections;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minPq = new PriorityQueue<>();
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        int insert = 0;
        int delete = 0;
        
        for (String o : operations) {
            String[] split = o.split(" ");
            if (split[0].equals("I")) {
                minPq.offer(Integer.parseInt(split[1]));
                maxPq.offer(Integer.parseInt(split[1]));
                insert++;
            } else if (split[0].equals("D")) {
                if (insert == delete) continue;
                if (split[1].startsWith("-")) {
                    int min = minPq.poll();
                    maxPq.remove(min);
                } else {
                    int max = maxPq.poll();
                    minPq.remove(max);
                }
                delete++;
            }
        }
        
        if (insert == delete) return new int[]{0, 0};
        return new int[]{maxPq.poll(), minPq.poll()};
    }
}