import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int m = scanner.nextInt();
        int n = scanner.nextInt();
        scanner.close();

        List<Integer> primeList = new ArrayList<>();

        // 입력된 값들 사이의 소수를 뽑아내기
        for (int i = m; i <= n; i++) {
            if (isPrime(i)) {
                primeList.add(i);
            }
        }

        for (Integer integer : primeList) {
            System.out.println(integer);
        }

    }

    // 소수 판별 메서드
    private static boolean isPrime(int value) {
        if (value < 2) return false;
        for (int i = 2; i <= Math.sqrt(value); i++) {
            if (value % i == 0) {
                return false;
            }
        }

        return true;
    }
}