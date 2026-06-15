import java.util.*;

class Solution {
    
    public int solution(String s) {
        int answer = s.length();
        
        for (int i = 1; i <= s.length() / 2; i++) {
            answer = Math.min(answer, compressText(s, i));
        }
        return answer;
    } 
    
    private int compressText(String s, int length) {
        List<String> parsedText = new ArrayList<>();
        for (int i = 0; i < s.length(); i += length) {
            parsedText.add(s.substring(i, Math.min(s.length(), i + length)));
        }
        
        StringBuilder sb = new StringBuilder();
        String prevString = "";
        int count = 0;
        
        for (String text : parsedText) {
            if (text.equals(prevString)) {
                count++;
            } else {
                if (count > 1) {
                    sb.append(String.valueOf(count));
                }
                
                sb.append(prevString);
                prevString = text;
                count = 1;
            }
        }
        
        if (count > 1) {
            sb.append(String.valueOf(count));
        }
        sb.append(prevString);
        return sb.toString().length();
    }
}