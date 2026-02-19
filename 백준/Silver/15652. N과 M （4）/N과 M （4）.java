import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        output = new int[R];
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        repeatCombination(0, 0, N, R);
        System.out.print(sb.toString());
    }

    private static void repeatCombination(int start, int depth, int N, int R) {
        if (depth == R) {
            for (int i = 0; i < R; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            output[depth] = arr[i];
            repeatCombination(i, depth + 1, N, R);
        }
    }
}