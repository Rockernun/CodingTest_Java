import java.util.*;
import java.util.stream.Collectors;

public class Main {
    
    static class Balloon {
        int number;
        int value;
        
        public Balloon(int number, int value) {
            this.number = number;
            this.value = value;
        }
        
        public int getNumber() {
            return number;
        }
        
        public int getValue() {
            return value;
        }
    }
    
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        sc.nextLine();  
        String[] input = sc.nextLine().split(" ");
        
        Deque<Balloon> deque = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        
        for (int i = 1; i <= N; i++) {
            deque.offerLast(new Balloon(i, Integer.parseInt(input[i - 1])));
        }
        
        while (!deque.isEmpty()) {
            Balloon currentBalloon = deque.pollFirst();
            result.add(currentBalloon.getNumber());
            
            if (deque.isEmpty()) {
                break;
            }
            
            if (currentBalloon.getValue() > 0) {
                for (int i = 0; i < currentBalloon.getValue() - 1; i++) {
                    deque.offerLast(deque.pollFirst());
                }
            } else {
                for (int i = 0; i < Math.abs(currentBalloon.getValue()); i++) {
                    deque.offerFirst(deque.pollLast());
                }
            }
        }
        
        System.out.println(result.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}