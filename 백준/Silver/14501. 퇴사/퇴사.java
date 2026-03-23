import java.util.Scanner;
import java.util.Arrays;

public class Main {
    
    static int N;
    static int[][] counselingAndPay;
    static int[] dp;
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        counselingAndPay = new int[N + 1][2];
        
        for (int i = 1; i <= N; i++) {
            counselingAndPay[i][0] = sc.nextInt();
            counselingAndPay[i][1] = sc.nextInt();
        }
        
        dp = new int[N + 1];
        Arrays.fill(dp, -1);
        
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            answer = Math.max(answer, recursion(i));
        }
        
        System.out.println(answer);
    }
    
    private static int recursion(int day) {
        if (dp[day] != -1) {
            return dp[day];
        }
        
        if (day + counselingAndPay[day][0] > N + 1) {
            return 0;
        }
        
        dp[day] = counselingAndPay[day][1];
        
        for (int i = day + counselingAndPay[day][0]; i <= N; i++) {
            if (i + counselingAndPay[i][0] <= N + 1) {
                dp[day] = Math.max(dp[day], counselingAndPay[day][1] + recursion(i));
            }
        }
        
        return dp[day];
    }
}