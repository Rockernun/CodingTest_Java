import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> q = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String line = br.readLine();

            if (line.startsWith("push_front")) {
                q.offerFirst(Integer.parseInt(line.split(" ")[1]));
            } else if (line.startsWith("push_back")) {
                q.offerLast(Integer.parseInt(line.split(" ")[1]));
            } else if (line.startsWith("pop_front")) {
                sb.append(q.isEmpty() ? -1 : q.pollFirst()).append('\n');
            } else if (line.startsWith("pop_back")) {
                sb.append(q.isEmpty() ? -1 : q.pollLast()).append('\n');
            } else if (line.charAt(0) == 's') { 
                sb.append(q.size()).append('\n');
            } else if (line.charAt(0) == 'e') { 
                sb.append(q.isEmpty() ? 1 : 0).append('\n');
            } else if (line.charAt(0) == 'f') { 
                sb.append(q.isEmpty() ? -1 : q.peekFirst()).append('\n');
            } else { 
                sb.append(q.isEmpty() ? -1 : q.peekLast()).append('\n');
            }
        }

        System.out.print(sb.toString());
    }
}
