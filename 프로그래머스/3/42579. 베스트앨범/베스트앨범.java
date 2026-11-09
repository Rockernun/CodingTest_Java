import java.util.*;

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> answer = new ArrayList<>();
        
        Map<String, Integer> playCount = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            playCount.put(genres[i], playCount.getOrDefault(genres[i], 0) + plays[i]);
        }

        List<String> mostPlayedGenres = new ArrayList<>(playCount.keySet());
        mostPlayedGenres.sort((a, b) -> Integer.compare(playCount.get(b), playCount.get(a)));
        
        for (String g : mostPlayedGenres) {
            List<int[]> songIdx = new ArrayList<>();  
            for (int i = 0; i < genres.length; i++) {
                if (genres[i].equals(g)) songIdx.add(new int[]{i, plays[i]});
            }
            
            songIdx.sort((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            });
            
            if (songIdx.size() == 1) answer.add(songIdx.get(0)[0]);
            if (songIdx.size() >= 2) {
                answer.add(songIdx.get(0)[0]);
                answer.add(songIdx.get(1)[0]);
            }
        }
        
        return answer.stream().mapToInt(x -> x).toArray();
    }
}