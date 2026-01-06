import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<Integer> solution(String[] genres, int[] plays) {
        Map<String, Integer> eachGenreTotalPlaySongs = new HashMap<>();
        Map<String, List<int[]>> playedSongsByGenre = new HashMap<>();
        for (int i = 0; i < genres.length; i++) {
            String genre = genres[i];
            int play = plays[i];

            if (eachGenreTotalPlaySongs.containsKey(genre)) {
                eachGenreTotalPlaySongs.put(genre, eachGenreTotalPlaySongs.get(genre) + play);
                playedSongsByGenre.get(genre).add(new int[]{i, play});
            } else {
                eachGenreTotalPlaySongs.put(genre, play);
                List<int[]> list = new ArrayList<>();
                list.add(new int[]{i, play});
                playedSongsByGenre.put(genre, list);
            }
        }
        
        List<Map.Entry<String, Integer>> sortedGenrePlays = new ArrayList<>(eachGenreTotalPlaySongs.entrySet());
        sortedGenrePlays.sort((a, b) -> b.getValue().compareTo(a.getValue()));
        
        List<Integer> list = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : sortedGenrePlays) {
            String genre = entry.getKey();
            List<int[]> genreIndexPlayList = playedSongsByGenre.get(genre);
            
            genreIndexPlayList.sort((a, b) -> {
                if (b[1] != a[1]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            });
            
            int genreSongCount = 0;
            for (int[] playedSong : genreIndexPlayList) {
                if (genreSongCount >= 2) {
                    break;
                }
                
                list.add(playedSong[0]);
                genreSongCount++;
            }
        }
        return list;
    }
}