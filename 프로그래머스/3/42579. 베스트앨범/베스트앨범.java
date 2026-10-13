import java.util.*;

class Solution {   
    public int[] solution(String[] genres, int[] plays) {
        List<Integer> result = new ArrayList<>();  // 결과를 담을 리스트
        Map<String, Integer> genresCount = new HashMap<>();  // 각 장르 노래가 재생된 총합
        
        for (int i = 0; i < genres.length; i++) {
            genresCount.put(genres[i], genresCount.getOrDefault(genres[i], 0) + plays[i]);
        }
        
        // 각 장르 노래가 재생된 총합을 기준으로 내림차순 (모든 장르는 재생된 횟수가 다르기 때문에 가능)
        List<Integer> countDesc = new ArrayList<>();
        for (int songs : genresCount.values()) {
            countDesc.add(songs);
        }
        
        Collections.sort(countDesc, Collections.reverseOrder());
        
        // 장르 노래가 재생된 총합이 같은 장르를 sortedGenres에 삽입
        List<String> sortedGenres = new ArrayList<>(genresCount.keySet());
        sortedGenres.sort((a, b) -> Integer.compare(genresCount.get(b), genresCount.get(a)));   // 총 재생 수 내림차순
        
        // 속한 노래가 많이 재생된 장르 순으로 정렬되어 있는 sortedGenres를 순회하면서
        for (int i = 0; i < sortedGenres.size(); i++) {
            List<int[]> list = new ArrayList<>();
            String currentGenre = sortedGenres.get(i);
            
            for (int g = 0; g < genres.length; g++) {
                if (genres[g].equals(currentGenre)) {
                    list.add(new int[]{g, plays[g]});
                }
            }
            
            list.sort((a, b) -> {
                if (a[1] != b[1]) return Integer.compare(b[1], a[1]);
                return Integer.compare(a[0], b[0]);
            });
            
            if (list.size() > 1) {
                result.add(list.get(0)[0]);
                result.add(list.get(1)[0]);
            } else {
                result.add(list.get(0)[0]);
            }
        }
         
        return result.stream().mapToInt(i -> i).toArray();
    }
}