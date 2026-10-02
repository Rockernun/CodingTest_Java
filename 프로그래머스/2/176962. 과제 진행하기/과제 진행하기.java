import java.util.*;

class Solution {
    public String[] solution(String[][] plans) {
        Deque<Integer> queue = new ArrayDeque<>();
        Deque<Integer> stack = new ArrayDeque<>();
        
        int[][] startAndTime = new int[plans.length][2];  // [시작 시각, 남은 시간]
        List<Integer> answer = new ArrayList<>();
        
        for (int i = 0; i < plans.length; i++) {
            String[] current = plans[i];
            startAndTime[i][0] = Integer.parseInt(current[1].split(":")[0]) * 60 + Integer.parseInt(current[1].split(":")[1]);
            startAndTime[i][1] = Integer.parseInt(current[2]);
        }
        
        Integer[] order = new Integer[plans.length];
        for (int i = 0; i < plans.length; i++) {
            order[i] = i;
        }
        
        Arrays.sort(order, (a, b) -> Integer.compare(startAndTime[a][0], startAndTime[b][0]));
        for (int idx : order) {
            queue.offer(idx);
        }
        
        Integer current = null;  // 지금 하고 있는 과제 (없으면 null)
        int time = startAndTime[queue.peekFirst()][0];
        
        while (answer.size() < plans.length) {
            if (!queue.isEmpty() && startAndTime[queue.peekFirst()][0] == time) {  // 다음 과제를 시작할 시각이 됨
                if (current != null) {  // 하고 있는 과제가 있다면
                    stack.push(current);
                }
                
                current = queue.poll();
            }
            
            // 하던 과제가 없다면
            if (current == null && !stack.isEmpty()) {
                current = stack.pop();
            }
            
            if (current != null) {
                startAndTime[current][1]--;
                if (startAndTime[current][1] == 0) {
                    answer.add(current);
                    current = null;
                }
            }
            
            time++;
        }
        
        String[] result = new String[plans.length];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = plans[answer.get(i)][0];
        }
        
        return result;
    }
}