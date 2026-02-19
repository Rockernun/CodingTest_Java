import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] output;
    static boolean[] visited;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input = sc.nextLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int R = Integer.parseInt(input[1]);
        output = new int[R];
        visited = new boolean[N];
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = i + 1;
        }

        combination(0, 0, N, R);
    }

    private static void combination(int start, int depth, int N, int R) {
        if (depth == R) {
            for (int i : output) {
                System.out.print(i + " ");
            }
            System.out.println();
            return;
        }

        for (int i = start; i < N; i++) {
            output[depth] = arr[i];
            combination(i + 1, depth + 1, N, R);
        }
    }
}