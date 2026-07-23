import java.util.*;

class Solution {

    Map<String, List<String>> adjList;
    Set<String> visited;
    int answer = Integer.MAX_VALUE;

    public int solution(String begin, String target, String[] words) {

        // target이 없는 경우
        if (!Arrays.asList(words).contains(target)) {
            return 0;
        }

        List<String> wordList = new ArrayList<>();
        wordList.add(begin);
        wordList.addAll(Arrays.asList(words));

        adjList = new HashMap<>();
        visited = new HashSet<>();

        for (String word : wordList) {
            adjList.put(word, new ArrayList<>());
        }

        // 한 글자 차이나는 단어끼리 연결
        for (String word1 : wordList) {
            for (String word2 : words) {
                if (isDiffOneChar(word1, word2)) {
                    adjList.get(word1).add(word2);
                }
            }
        }

        dfs(begin, target, 0);

        return answer == Integer.MAX_VALUE ? 0 : answer;
    }

    private void dfs(String current, String target, int depth) {

        if (current.equals(target)) {
            answer = Math.min(answer, depth);
            return;
        }

        visited.add(current);

        for (String next : adjList.get(current)) {
            if (!visited.contains(next)) {
                dfs(next, target, depth + 1);
            }
        }

        visited.remove(current);
    }

    private boolean isDiffOneChar(String str1, String str2) {

        int diff = 0;

        for (int i = 0; i < str1.length(); i++) {
            if (str1.charAt(i) != str2.charAt(i)) {
                diff++;
            }
        }

        return diff == 1;
    }
}