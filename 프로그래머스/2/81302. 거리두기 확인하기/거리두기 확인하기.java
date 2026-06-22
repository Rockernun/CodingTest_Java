import java.util.*;

class Solution {
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++) {
            boolean result = keepDistance(places[i]);
            if (!result) {
                answer[i] = 0;
            } else {
                answer[i] = 1;
            }
        }
        return answer;
    }

    // ["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"]
    private boolean keepDistance(String[] place) {
        List<int[]> participantPosition = new ArrayList<>();

        // 참가자 위치 파악
        for (int i = 0; i < place.length; i++) {
            for (int j = 0; j < place[i].length(); j++) {
                if (place[i].charAt(j) == 'P') {
                    participantPosition.add(new int[]{i, j});
                }
            }
        }

        // participantPosition = [[0, 0], [0, 4], [2, 1], [2, 3], [4, 0], [4, 4]]
        for (int i = 0; i < participantPosition.size() - 1; i++) {
            for (int j = i + 1; j < participantPosition.size(); j++) {
                int distance = Math.abs(participantPosition.get(i)[0] - participantPosition.get(j)[0]) + Math.abs(
                        participantPosition.get(i)[1] - participantPosition.get(j)[1]);

                if (distance == 1) {
                    return false;
                }

                if (distance == 2) {
                    if (participantPosition.get(i)[0] == participantPosition.get(j)[0]
                            && participantPosition.get(i)[1] != participantPosition.get(j)[1]) {
                        int between = (participantPosition.get(i)[1] + participantPosition.get(j)[1]) / 2;
                        if (place[participantPosition.get(i)[0]].charAt(between) == 'O') {
                            return false;
                        }
                    } else if (participantPosition.get(i)[0] != participantPosition.get(j)[0]
                            && participantPosition.get(i)[1] == participantPosition.get(j)[1]) {
                        int between = (participantPosition.get(i)[0] + participantPosition.get(j)[0]) / 2;
                        if (place[between].charAt(participantPosition.get(i)[1]) == 'O') {
                            return false;
                        }
                    } else if (participantPosition.get(i)[0] != participantPosition.get(j)[0]
                            && participantPosition.get(i)[1] != participantPosition.get(j)[1]) {
                        if (place[participantPosition.get(i)[0]].charAt(participantPosition.get(j)[1]) != 'X'
                                || place[participantPosition.get(j)[0]].charAt(participantPosition.get(i)[1]) != 'X') {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }
}