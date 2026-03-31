import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] numArr = new int[N][M];

        // 2차원 배열 초기화
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                numArr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < Math.min(N, M) / 2; j++) {
                int temp = numArr[j][j];
                
				for (int k = j; k < M - j - 1; k++) {
					numArr[j][k] = numArr[j][k+1];
				}
				
				for (int k = j; k < N - 1 - j; k++) {
					numArr[k][M - j -1] = numArr[k + 1][M - j - 1];
				}
				
				for (int k = M - j - 1; k > j; k--) {
					numArr[N - 1 -j][k] = numArr[N - 1 -j][k - 1];
				}
				
				for (int k = N - j -1; k > j; k--) {
					numArr[k][j] = numArr[k - 1][j];
				}
				
				numArr[j + 1][j] = temp;
            }
        }
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(numArr[i][j]).append(" ");
            }
            
            sb.append("\n");
        }
        
        System.out.println(sb);
    }
}
