import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();

        for (int i = Math.max(2, m); i <= n; i++) {
            boolean isPrime = true;
            for (int j = 2; j * j <= i; j++) {   
                if (i % j == 0) {             
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                System.out.println(i);    
            }
        }
    }
}