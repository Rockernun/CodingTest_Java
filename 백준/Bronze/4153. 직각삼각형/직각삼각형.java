import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            if (str.equals("0 0 0")) {
                break;
            }

            String[] numbers = str.split(" ");
            List<Integer> list = new ArrayList<>();
            for (String number : numbers) {
                list.add(Integer.parseInt(number));
            }

            Collections.sort(list);

            if (list.get(0) * list.get(0) + list.get(1) * list.get(1) == list.get(2) * list.get(2)) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}