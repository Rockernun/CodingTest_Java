import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }

        System.out.print("<");
        while (queue.size() > 1) {
            for (int i = 0; i < k - 1; i++) {
                Integer polled = queue.poll();
                queue.offer(polled);
            }
            System.out.print(queue.poll() + ", ");
        }
        System.out.print(queue.poll() + ">");
    }
}
