import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    static final char[] arr = {'A', 'E', 'I', 'O', 'U'};

    static void dfs(StringBuilder sb, List<String> output) {
        if (sb.length() > 0) {
            output.add(sb.toString());
        }

        if (sb.length() == arr.length) {
            return;
        }

        for (char c : arr) {
            sb.append(c);
            dfs(sb, output);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public int solution(String word) {
        List<String> list = new ArrayList<>();
        dfs(new StringBuilder(), list);

        Collections.sort(list);
        
        return list.indexOf(word) + 1;
    }
}