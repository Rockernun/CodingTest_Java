import java.util.List;
import java.util.ArrayList;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            if (distancing(places[i])) {
                answer[i] = 1;
            } else {
                answer[i] = 0;
            }
        }
        
        return answer;
    }
    
    private boolean distancing(String[] place) {
        char[][] map = new char[5][5];
        List<int[]> people = new ArrayList<>();
        
        for (int r = 0; r < place.length; r++) {
            for (int c = 0; c < place[r].length(); c++) {
                map[r][c] = place[r].charAt(c);
                if (place[r].charAt(c) == 'P') people.add(new int[]{r, c});
            }
        }
        
        for (int i = 0; i < people.size() - 1; i++) {
            for (int j = i + 1; j < people.size(); j++) {
                int startR = people.get(i)[0], startC = people.get(i)[1];
                int targetR = people.get(j)[0], targetC = people.get(j)[1];
                if (manhattanDistance(startR, startC, targetR, targetC) == 1) return false;
                if (manhattanDistance(startR, startC, targetR, targetC) == 2) {
                    if (startR == targetR && place[startR].charAt((startC + targetC) / 2) != 'X') return false;
                    if (startC == targetC && place[(startR + targetR) / 2].charAt(startC) != 'X') return false;
                    if (startR != targetR && startC != targetC) {
                        if (place[startR].charAt(targetC) != 'X' || place[targetR].charAt(startC) != 'X') return false;
                    }
                }
            }
        }
        
        return true;
    }
    
    private int manhattanDistance(int startR, int startC, int targetR, int targetC) {
        return Math.abs(targetR - startR) + Math.abs(targetC - startC);
    }
}