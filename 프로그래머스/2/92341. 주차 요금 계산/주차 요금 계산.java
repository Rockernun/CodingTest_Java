import java.util.*;

class Solution {
    
    static int time;
    static int fee;
    static int unitTime;
    static int unitFee;
    static int[] answer;
    
    public int[] solution(int[] fees, String[] records) {
        Set<Integer> cars = new HashSet<>();
        Map<Integer, List<Integer>> info = new HashMap<>();
        
        time = fees[0]; 
        fee = fees[1];  
        unitTime = fees[2];  
        unitFee = fees[3];
        
        for (String record : records) {
            String[] split = record.split(" ");
            String[] clock = split[0].split(":");
            int minutes = Integer.parseInt(clock[0]) * 60 + Integer.parseInt(clock[1]);
            int carNum = Integer.parseInt(split[1]);
            
            if (!cars.contains(carNum)) {
                cars.add(carNum);
                info.put(carNum, new ArrayList<>());
                info.get(carNum).add(minutes);
            } else { 
                info.get(carNum).add(minutes);
            }
        }
        
        List<Integer> sortedNumber = new ArrayList<>(cars);
        Collections.sort(sortedNumber);
        answer = new int[sortedNumber.size()];
        
        for (int i = 0; i < sortedNumber.size(); i++) {
            List<Integer> record = info.get(sortedNumber.get(i));  
            
            if (record.size() == 1) {
                int totalTime = (23 * 60 + 59) - record.get(0);
                getTotalPrice(i, totalTime);
                continue;
            }
            
            if (record.size() % 2 == 0) {
                int totalTime = 0;
                for (int j = 0; j < record.size(); j++) {
                    if (j % 2 == 0) {
                        totalTime -= record.get(j);
                    } else {
                        totalTime += record.get(j);
                    }
                }
                getTotalPrice(i, totalTime);
            } else { 
                int totalTime = 0;
                for (int j = 0; j < record.size() - 1; j++) {
                    if (j % 2 == 0) {
                        totalTime -= record.get(j);
                    } else {
                        totalTime += record.get(j);
                    }
                }
                totalTime += (23 * 60 + 59) - record.get(record.size() - 1);
                getTotalPrice(i, totalTime);
            }
        }
        
        return answer;
    }
    
    private void getTotalPrice(int idx, int totalTime) {
        if (totalTime <= time) {
            answer[idx] = fee;
            return;
        }
        
        int exceed = totalTime - time;
        if (exceed % unitTime != 0) {
            answer[idx] = fee + (exceed / unitTime) * unitFee + unitFee;
        } else {
            answer[idx] = fee + (exceed / unitTime) * unitFee; 
        }
    
    }
}