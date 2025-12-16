import java.util.Scanner;

public class Main {
    public static long calculate(long n) {
        long sum = 0L;
        long count = 0L;

        for (long i = 1; i <= n; i++) {
            sum += i;
            count++;
            if (sum > n) {
                count--;
                break;
            }

            if (sum == n) {
                break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        System.out.println(calculate(n));
    }
}
