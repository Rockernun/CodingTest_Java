import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        HashMap<Character, Integer> map = new LinkedHashMap<>();

        for (char c : str.toCharArray()) {
            map.put(Character.toLowerCase(c), map.getOrDefault(Character.toLowerCase(c), 0) + 1);
        }

        int max = 0;
        for (int i : map.values()) {
            if (i > max) {
                max = i;
            }
        }

        List<Character> mostFrequentChars = new ArrayList<>();
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            if (e.getValue() == max) {
                mostFrequentChars.add(e.getKey());
            }
        }

        if (mostFrequentChars.size() == 1) {
            System.out.println(Character.toUpperCase(mostFrequentChars.get(0)));
        } else {
            System.out.println("?");
        }
    }
}