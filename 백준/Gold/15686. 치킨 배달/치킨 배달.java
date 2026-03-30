import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

// 5 3
// 0 0 1 0 0
// 0 0 2 0 1
// 0 1 2 0 0
// 0 0 1 0 0
// 0 0 0 0 2

// 5 2
// 0 2 0 1 0
// 1 0 1 0 0
// 0 0 0 0 0
// 2 0 0 1 1
// 2 2 0 1 2

// 5 1
// 1 2 0 2 1
// 1 2 0 2 1
// 1 2 0 2 1
// 1 2 0 2 1
// 1 2 0 2 1

public class Main {
    
    static int[][] cityMap;
    static List<int[]> eachHousePosition;
    static List<int[]> chickenPosition; 
    static int[][] output;
    static int totalChickenDistance = Integer.MAX_VALUE;
    
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        cityMap = new int[N][N];
        eachHousePosition = new ArrayList<>();
        chickenPosition = new ArrayList<>();
        output = new int[M][2];
        
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int value = Integer.parseInt(st.nextToken());
                cityMap[i][j] = value;

                if (value == 1) {
                    eachHousePosition.add(new int[]{i, j});
                } else if (value == 2) {
                    chickenPosition.add(new int[]{i, j});
                }
            }
        }
        
        combination(0, 0, chickenPosition.size(), M);
        System.out.println(totalChickenDistance);
        
    }
    
    private static void combination(int start, int depth, int n, int r) {
        if (depth == r) {
            int totalDistance = calculateTotalChickenDistance(eachHousePosition, output);
            totalChickenDistance = Math.min(totalChickenDistance, totalDistance);
            return;
        }
        
        for (int i = start; i < n; i++) {
            output[depth] = chickenPosition.get(i);	
		    combination(i + 1, depth + 1, n, r);
        }
    }
    
    private static int calculateTotalChickenDistance(List<int[]> housePosition, int[][] output) {
        int totalDistance = 0;
        for (int[] house : housePosition) { 
            int min = Integer.MAX_VALUE;
            for (int[] chickenShop : output) {
                min = Math.min(min, Math.abs(house[0] - chickenShop[0]) + Math.abs(house[1] - chickenShop[1]));
            }
            
            totalDistance += min;
        }
        
        return totalDistance;
    }
}
