import java.util.*;

public class Main {

    static int[] output = new int[3];
    static int count = 0;
    static boolean[][] doNotEat; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        doNotEat = new boolean[N + 1][N + 1];
        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            doNotEat[a][b] = true;
            doNotEat[b][a] = true;
        }

        combination(1, 0, N);

        System.out.println(count);
    }

    private static void combination(int start, int depth, int N) {
        if (depth == 3) {
            int a = output[0];
            int b = output[1];
            int c = output[2];
            
            if (!doNotEat[a][b] && !doNotEat[a][c] && !doNotEat[b][c]) {
                count++;
            }
            
            return; 
        }

        for (int i = start; i <= N; i++) {
            output[depth] = i;
            combination(i + 1, depth + 1, N);
        }
    }
}
