import java.util.*;

class Solution {
    
    Map<Integer, List<Integer>> win;
    Map<Integer, List<Integer>> lose;
    int[] dist;
    
    public int solution(int n, int[][] results) {
        win = new HashMap<>();
        lose = new HashMap<>();
        dist = new int[n + 1];
        Arrays.fill(dist, -1);
        
        for (int i = 1; i <= n; i++) {
            win.put(i, new ArrayList<>());
            lose.put(i, new ArrayList<>());
        }
        
        for (int[] result : results) {
            win.get(result[0]).add(result[1]);
            lose.get(result[1]).add(result[0]); 
        }

        for (int i = 1; i <= n; i++) {
            List<Integer> winList = win.get(i);
            for (int j = 0; j < winList.size(); j++) { 
                for (int w : win.get(winList.get(j))) {
                    if (!winList.contains(w)) winList.add(w);
                }
            }

            List<Integer> loseList = lose.get(i);
            for (int j = 0; j < loseList.size(); j++) {
                for (int l : lose.get(loseList.get(j))) {
                    if (!loseList.contains(l)) loseList.add(l);
                }
            }
        }
        
        for (int i = 1; i <= n; i++) {
            List<Integer> mergedList = new ArrayList<>(win.get(i));
            mergedList.addAll(lose.get(i));
            if (mergedList.size() != n - 1) continue;
            dist[i] = n - win.get(i).size();
        }
        
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            if (dist[i] == -1) continue;
            answer++;
        }
        
        return answer;
    }
}