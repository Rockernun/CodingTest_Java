import java.util.*;

class Solution {
    
    private static final String DELIMITER = ":";
    private static final String TARGET_FORMAT = "},{";
    
    public int[] solution(String s) {
        String parseNumbers = s.substring(2, s.length() - 2).replace(TARGET_FORMAT, DELIMITER);

        String[] sortedArray = Arrays.stream(parseNumbers.split(DELIMITER))
            .sorted(Comparator.comparingInt(String::length))
            .toArray(String[]::new);
        
        List<List<String>> result = new ArrayList<>();
        
        for (int i = 0; i < sortedArray.length; i++) { 
            result.add(Arrays.asList(sortedArray[i].split(",")));
        }

        int[] answer = new int[sortedArray.length];
        answer[0] = Integer.parseInt(sortedArray[0]);
        
        for (int i = 1; i < result.size(); i++) {
            Set<String> previousSet = new HashSet<>(result.get(i - 1));
            Set<String> currentSet = new HashSet<>(result.get(i));
            
            currentSet.removeAll(previousSet);
            answer[i] = Integer.parseInt(currentSet.iterator().next());
        }
        
        return answer;
    }
}