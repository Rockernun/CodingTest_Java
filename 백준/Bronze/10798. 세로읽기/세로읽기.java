import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> list = new ArrayList<>();
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            list.add(sc.nextLine());
        }

        int maxSize = list.get(0).length();
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).length() > maxSize) {
                maxSize = list.get(i).length();
            }
        }

        for (int i = 0; i < maxSize; i++) {
            for (int j = 0; j < 5; j++) {
                if (list.get(j).length() > i) {
                    Character a = list.get(j).charAt(i);
                    result.add(a + "");
                }
            }
        }

        for (String s : result) {
            System.out.print(s);
        }
    }
}