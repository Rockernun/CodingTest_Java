import java.util.*;

class Solution {
    
    Map<List<String>, List<Integer>> combinations;
    String[] lang = {"cpp", "java", "python"};
    String[] part = {"backend", "frontend"};
    String[] career = {"junior", "senior"};
    String[] food = {"chicken", "pizza"};
    
    public int[] solution(String[] info, String[] query) {
        combinations = new HashMap<>();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 2; k++) {
                    for (int l = 0; l < 2; l++) {
                        combinations.put(List.of(lang[i], part[j], career[k], food[l]), new ArrayList<>());
                    }
                }
            }
        }
        
        for (int i = 0; i < info.length; i++) {
            String[] s = info[i].split(" ");
            String lang = s[0];
            String part = s[1];
            String career = s[2];
            String food = s[3];
            String score = s[4];
            
            List<String> person = List.of(lang, part, career, food);
            combinations.get(person).add(Integer.parseInt(score));
        }
        
        for (List<Integer> scores : combinations.values()) {
            Collections.sort(scores);
        }
        
        int[] answer = new int[query.length];
        
        for (int i = 0; i < query.length; i++) {  // 최대 10만
            // -, backend, senior, - 150
            // java, backend, junior, pizza 100
            String[] s1 = query[i].split(" and ");
            String[] s2 = s1[s1.length - 1].split(" ");
            String food = s2[0];
            int score = Integer.parseInt(s2[1]);
            
            List<String> list = List.of(s1[0], s1[1], s1[2], food);
            
            for (List<String> key : combinations.keySet()) {  // 최대 24
                String keyLang = key.get(0);
                String keyPart = key.get(1);
                String keyCareer = key.get(2);
                String keyFood = key.get(3);
                
                if (!list.get(0).equals("-") && !key.get(0).equals(list.get(0))) continue;
                if (!list.get(1).equals("-") && !key.get(1).equals(list.get(1))) continue;
                if (!list.get(2).equals("-") && !key.get(2).equals(list.get(2))) continue;
                if (!list.get(3).equals("-") && !key.get(3).equals(list.get(3))) continue;
                
                List<Integer> scores = combinations.get(key);
                answer[i] += scores.size() - findFirstIndex(scores, score);
            }
        }
        
        return answer;
    }
    
    private int findFirstIndex(List<Integer> scores, int target) {
        int left = 0;
        int right = scores.size();
        
        while (left < right) {
            int mid = (left + right) / 2;
            if (scores.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return left;
    }
}