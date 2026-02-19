import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int[] arr;
    static int[] output;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] input1 = sc.nextLine().split(" ");
        int N = Integer.parseInt(input1[0]);
        int R = Integer.parseInt(input1[1]);
        
        String[] input2 = sc.nextLine().split(" ");
        
        output = new int[R];
        arr = new int[N];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);
        combination(0, 0, N, R);
        System.out.println(sb.toString());
    }

    private static void combination(int start, int depth, int N, int R) {
        if (depth == R) {
            for (int i = 0; i < R; i++) {
                sb.append(output[i]).append(' ');
            }
            sb.append('\n');
            return;
        }

        for (int i = start; i < N; i++) {
            output[depth] = arr[i];
            combination(i + 1, depth + 1, N, R);
        }
    }
}