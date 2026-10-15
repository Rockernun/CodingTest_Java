import java.util.PriorityQueue;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        
        for (String operation : operations) {
            String[] split = operation.split(" ");
            if (split[0].equals("I")) {
                if (split[1].charAt(0) == '-') {
                    minHeap.offer(Integer.parseInt(split[1].substring(1)) * -1);
                    maxHeap.offer(Integer.parseInt(split[1].substring(1)) * -1);
                } else {
                    minHeap.offer(Integer.parseInt(split[1]));
                    maxHeap.offer(Integer.parseInt(split[1]));
                }
            } else if (split[0].equals("D") && split[1].equals("1")) { 
                if (!maxHeap.isEmpty()) minHeap.remove(maxHeap.poll());
            } else if (split[0].equals("D") && split[1].equals("-1")) {
                if (!minHeap.isEmpty()) maxHeap.remove(minHeap.poll());
            }
        }
        
        if (maxHeap.isEmpty()) return new int[]{0, 0};
        return new int[]{maxHeap.poll(), minHeap.poll()};
    }
}