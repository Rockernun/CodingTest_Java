import java.util.*;

class Main {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine().trim();
        sc.close();

        // 연속된 같은 문자는 하나로 압축
        StringBuilder comp = new StringBuilder();
        comp.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(i - 1)) {
                comp.append(s.charAt(i));
            }
        }
        
        int zero = 0, one = 0;
        for (int i = 0; i < comp.length(); i++) {
            if (comp.charAt(i) == '0') zero++;
            else if (comp.charAt(i) == '1') one++;
        }
        
        System.out.println(Math.min(zero, one));
    }
}