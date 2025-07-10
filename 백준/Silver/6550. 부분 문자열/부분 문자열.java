import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split(" ");
            if (parts.length != 2) continue;

            String s = parts[0];
            String t = parts[1];

            System.out.println(isSubsequence(s, t));
        }

        sc.close();
    }

    private static String isSubsequence(String s, String t) {
        int i = 0, j = 0;

        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            
            j++;
        }

        return (i == s.length()) ? "Yes" : "No"; 
    }
}