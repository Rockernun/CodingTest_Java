import java.util.*;

class Solution {

    List<long[]> list = new ArrayList<>();  // x, y좌표가 정수인 교점들

    public String[] solution(int[][] line) {
        for (int i = 0; i < line.length - 1; i++) {
            for (int j = i + 1; j < line.length; j++) {
                long A = line[i][0], B = line[i][1], E = line[i][2];
                long C = line[j][0], D = line[j][1], F = line[j][2];

                long denominator = A * D - B * C;
                if (denominator == 0) {
                    continue;
                }

                long numX = B * F - E * D;
                long numY = E * C - A * F;
                if (numX % denominator != 0 || numY % denominator != 0) {
                    continue;
                }

                list.add(new long[]{numX / denominator, numY / denominator});
            }
        }

        // list를 순회하면서 가장 작은/큰 x, 가장 작은/큰 y를 뽑아낸다.
        long minX = list.get(0)[0], maxX = list.get(0)[0];
        long minY = list.get(0)[1], maxY = list.get(0)[1];

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i)[0] < minX) minX = list.get(i)[0];
            if (list.get(i)[0] > maxX) maxX = list.get(i)[0];
            if (list.get(i)[1] < minY) minY = list.get(i)[1];
            if (list.get(i)[1] > maxY) maxY = list.get(i)[1];
        }

        int width = (int) (maxX - minX + 1);  // 열 개수
        int height = (int) (maxY - minY + 1);  // 행 개수

        // 모든 행을 '.'으로 채움
        StringBuilder[] rows = new StringBuilder[height];
        for (int i = 0; i < height; i++) {
            rows[i] = new StringBuilder();
            for (int j = 0; j < width; j++) {
                rows[i].append('.');
            }
        }

        // 교점 위치에 '*'를 찍는다.
        for (long[] star : list) {
            int row = (int) (maxY - star[1]);  // y가 클수록 위쪽
            int col = (int) (star[0] - minX);  // x가 작을수록 왼쪽
            rows[row].setCharAt(col, '*');
        }

        String[] result = new String[height];
        for (int i = 0; i < height; i++) {
            result[i] = rows[i].toString();
        }

        return result;
    }
}