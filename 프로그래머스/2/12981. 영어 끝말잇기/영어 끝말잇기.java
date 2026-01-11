import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public static List<Integer> solution(int n, String[] words) {
        Set<String> set = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        
        set.add(words[0]);

        for (int i = 1; i < words.length; i++) {
            String previousWord = words[i - 1];
            String currentWord = words[i];

            int playerNumber = (i % n) + 1;
            int round = (i / n) + 1;

            if (previousWord.charAt(previousWord.length() - 1) != currentWord.charAt(0)) {
                result.add(playerNumber);
                result.add(round);
                return result;
            }

            if (!set.add(currentWord)) {
                result.add(playerNumber);
                result.add(round);
                return result;
            }
        }

        result.add(0);
        result.add(0);
        return result;
    }
}