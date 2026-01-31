import java.util.*;

class Solution {
    public long solution(long n) {
        String[] list = (n + "").split("");
        
        List<Integer> filteredList = new ArrayList<>();
        for (String s : list) {
            filteredList.add(Integer.parseInt(s));
        }
        
        Collections.sort(filteredList);
        Collections.reverse(filteredList);
        
        String answer = "";
        for (Integer number : filteredList) {
            answer += number + "";
        }
        
        return Long.parseLong(answer);
    }
}