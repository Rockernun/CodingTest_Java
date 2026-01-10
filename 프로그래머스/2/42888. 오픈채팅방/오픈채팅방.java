import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public static List<String> solution(String[] record) {
        Map<String, String> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (String s : record) {
            String[] splitCmd = s.split(" ");
            if (splitCmd[0].equals("Enter")) {
                map.put(splitCmd[1], splitCmd[2]);
            } else if (splitCmd[0].equals("Change")) {
                map.replace(splitCmd[1], splitCmd[2]);
            }
        }

        for (String s : record) {
            String[] splitCmd = s.split(" ");
            if (splitCmd[0].equals("Enter")) {
                list.add(map.get(splitCmd[1]) + "님이 들어왔습니다.");
            } else if (splitCmd[0].equals("Leave")) {
                list.add(map.get(splitCmd[1]) + "님이 나갔습니다.");
            }
        }

        return list;
    }
}