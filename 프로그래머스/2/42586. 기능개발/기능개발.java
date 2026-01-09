import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public static List<Integer> solution(int[] progresses, int[] speeds) {

        Deque<Integer> queue = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < progresses.length; i++) {
            int task = progresses[i];
            int count = 0;
            while (task < 100) {
                task += speeds[i];
                count++;
            }

            queue.add(count);
        }

        while (!queue.isEmpty()) {
            Integer headTask = queue.removeFirst();
            int finishedTask = 1;

            while (!queue.isEmpty() && queue.peekFirst() <= headTask) {
                finishedTask++;
                queue.removeFirst();
            }

            result.add(finishedTask);
        }

        return result;
    }
}