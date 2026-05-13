import java.util.*;

class Solution {
    
    static String[] newWords;
    static Map<Integer, List<Integer>> adjList;
    static boolean[] visited;
    
    public int solution(String begin, String target, String[] words) {
        adjList = new HashMap<>();
        newWords = new String[words.length + 1];
        newWords[0] = begin;
        
        for (int i = 1; i < newWords.length; i++) {
            newWords[i] = words[i - 1];
        }
        
        System.out.println(Arrays.toString(newWords));

        visited = new boolean[newWords.length];
        
        for (int i = 0; i < newWords.length; i++) {
            adjList.put(i, new ArrayList<>());
        }

        for (int i = 0; i < newWords.length - 1; i++) {
            for (int j = i + 1; j < newWords.length; j++) {
                if (findAdjcentElement(newWords[i], newWords[j])) {
                    adjList.get(i).add(j);
                    adjList.get(j).add(i);
                }
            }
        }
        
        return bfs(0, target);
    }
    
    private int bfs(int startIndex, String target) {
        Deque<Integer> queue = new ArrayDeque<>();
        int[] count = new int[newWords.length];
        queue.offer(startIndex);
        visited[startIndex] = true;
        
        while (!queue.isEmpty()) {
            int current = queue.poll();
            
            if (newWords[current].equals(target)) {
                return count[current];
            }
            
            for (int next : adjList.get(current)) {
                if (!visited[next]) {
                    count[next] = count[current] + 1;
                    queue.offer(next);
                    visited[next] = true;           
                }
            }
        }
        
        return 0;
    }
    
    private boolean findAdjcentElement(String currentWord, String nextWord) {
        int count = 0;
        
        for (int i = 0; i < currentWord.length(); i++) {
            if (currentWord.charAt(i) != nextWord.charAt(i)) {
                count++;
            }
        }
        
        if (count == 1) {
            return true;
        }
        
        return false;
    }
}