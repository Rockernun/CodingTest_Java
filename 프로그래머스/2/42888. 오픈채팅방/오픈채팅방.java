import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    private static final String ENTER = "Enter";
    private static final String LEAVE = "Leave";
    private static final String CHANGE = "Change";
    private static List<String> resultList = new ArrayList<>();
    
    public static List<String> solution(String[] record) {
        Map<String, String> userInfo = new HashMap<>();
        
        for (String command : record) {
            String[] splitCommand = command.split(" ");
            
            if (splitCommand[0].equals(ENTER)) {
                userInfo.put(splitCommand[1], splitCommand[2]);
            }
            
            if (splitCommand[0].equals(CHANGE)) {
                userInfo.put(splitCommand[1], splitCommand[2]);
            }
        }
        
        for (String command : record) {
            String[] commands = command.split(" ");
            
            if (commands[0].equals(ENTER)) {
                resultList.add(userInfo.get(commands[1]) + "님이 들어왔습니다.");
            }
            
            if (commands[0].equals(LEAVE)) {
                resultList.add(userInfo.get(commands[1]) + "님이 나갔습니다.");
            }
        }
        
        return resultList;
    }
}