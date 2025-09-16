import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        // 크기가 26인 배열 생성(인덱스: 0 ~ 25)
        int[] map = new int[26];
        for (int i = 0; i < 26; i++) {
            map[i] = -1;
        }

        // 문자열 입력
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();

        for (char c : str.toCharArray()) {
            // 알파벳을 숫자로
            int alphabetNumber = c - 'a';
            if (map[alphabetNumber] == -1) {
                map[alphabetNumber] = str.indexOf(c);
            }
        }

        for (int i : map) {
            System.out.print(i + " ");
        }

    }
}