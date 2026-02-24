import java.util.*;

public class Main {

    static int[] arr;
    static int[] output;
    static boolean[] visited;
    static Set<Integer> cardCombinations = new HashSet<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();

        arr = new int[n];
        output = new int[k];
        visited = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        
        permutation(0, n, k);
        System.out.println(cardCombinations.size());
    }

    private static void permutation(int depth, int n, int r) {
        if (depth == r) {
            sb.setLength(0);               
            for (int i = 0; i < r; i++) {
                sb.append(output[i]);       
            }
            
            cardCombinations.add(Integer.parseInt(sb.toString())); 
            return;
        }

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                output[depth] = arr[i];
                permutation(depth + 1, n, r);
                visited[i] = false;
            }
        }
    }
}
