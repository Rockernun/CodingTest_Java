import java.util.*;

class Solution {
    
    Map<String, List<String>> info;
    
    public String[] solution(String[] record) {
        info = new HashMap<>();
        int count = 0;
         
        for (String s : record) {
            String[] split = s.split(" ");
            if (!info.keySet().contains(split[1])) {
                info.put(split[1], new ArrayList<>());
            }
        }
        
        for (String s : record) {
            String[] split = s.split(" ");
            String command = split[0];
            if (command.equals("Enter")) {
                info.get(split[1]).add(split[2]);
                count++;
            } else if (command.equals("Change")) {
                info.get(split[1]).add(split[2]);
            } else if (command.equals("Leave")) {
                count++;
            }
        }
        
        String[] result = new String[count];
        int index = 0;
        
        for (int i = 0; i < record.length; i++) {
            String[] s = record[i].split(" ");
            String command = s[0];
            String uuid = s[1];
            
            if (command.equals("Enter")) {
                result[index++] = info.get(uuid).get(info.get(uuid).size() - 1) + "님이 들어왔습니다.";
            } else if (command.equals("Leave")) {
                result[index++] = info.get(uuid).get(info.get(uuid).size() - 1) + "님이 나갔습니다.";
            }
        }
        
        return result;
    }
}