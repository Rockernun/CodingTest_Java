import java.util.Scanner;

public class Main {
    public static int palindrome(int minIndex, int maxIndex, String str, int removeCount) {
        if (removeCount >= 2) {
            return 2;
        }

        while (minIndex < maxIndex) {
            if (str.charAt(minIndex) == str.charAt(maxIndex)) {
                minIndex++;
                maxIndex--;
            } else if (str.charAt(minIndex) != str.charAt(maxIndex)) {
                int leftIncrease = palindrome(minIndex + 1, maxIndex, str, removeCount + 1);
                int rightDecrease = palindrome(minIndex, maxIndex - 1, str, removeCount + 1);
                int minCount = Math.min(leftIncrease, rightDecrease);
                return minCount;
            }
        }

        return removeCount;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String str = scanner.next();
            int palindrome = palindrome(0, str.length() - 1, str, 0);
            if (palindrome == 0) {
                System.out.println(0);
            } else if (palindrome == 1) {
                System.out.println(1);
            } else {
                System.out.println(2);
            }
        }
    }
}
