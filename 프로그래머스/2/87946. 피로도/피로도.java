import java.util.*;

class Solution {
    
    public int solution(int k, int[][] dungeons) {
        int count = 0;

        int[] indexes = new int[dungeons.length];
        
        for (int i = 0; i < dungeons.length; i++) {
            indexes[i] = i;
        }
        
        List<List<Integer>> output = permutation(indexes, dungeons.length);
        
        for (int i = 0; i < output.size(); i++) {
            int currentK = k;
            int c = 0;

            for (int j = 0; j < output.get(i).size(); j++) {
                int index = output.get(i).get(j);

                if (currentK < dungeons[index][0]) {
                    break;
                }
                
                currentK -= dungeons[index][1];
                c++;
            }
            
            count = Math.max(count, c);
        }
        
        return count;
    }
    
    private List<List<Integer>> permutation(int[] indexes, int r) {
        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[indexes.length];

        backTrack(new ArrayList<>(), r, indexes, visited, answer);

        return answer;
    }
    
    private void backTrack(
        List<Integer> current,
        int r,
        int[] indexes,
        boolean[] visited,
        List<List<Integer>> answer
    ) {
        if (current.size() == r) {
            answer.add(new ArrayList<>(current));
            return;
        }
        
        for (int i = 0; i < indexes.length; i++) {
            if (!visited[i]) {
                current.add(indexes[i]);
                visited[i] = true;

                backTrack(current, r, indexes, visited, answer);

                current.remove(current.size() - 1);
                visited[i] = false;
            }
        }
    }
}