import java.util.*;

public class Main {

    static int N, K;
    static int[] arr;
    static int maxValue = 0; 

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] input1 = sc.nextLine().split(" ");
        String[] input2 = sc.nextLine().split(" ");

        N = Integer.parseInt(input1[0]);
        K = Integer.parseInt(input1[1]);

        arr = new int[K];
        for (int i = 0; i < K; i++) {
            arr[i] = Integer.parseInt(input2[i]);
        }

        Arrays.sort(arr);
        for (int i = 0; i < K / 2; i++) {
            int tmp = arr[i];
            arr[i] = arr[K - 1 - i];
            arr[K - 1 - i] = tmp;
        }

        int len = input1[0].length();

        for (int r = len; r >= 1; r--) {
            dfs(0, r, 0);
        }

        System.out.println(maxValue);
    }

    private static void dfs(int depth, int targetLen, int current) {
        if (current > N) {
            return;
        }

        if (depth == targetLen) {
            if (current > maxValue) {
                maxValue = current;
                return;
            }
        }

        for (int d : arr) {
            int next = current * 10 + d;
            dfs(depth + 1, targetLen, next);
        }
    }
}
