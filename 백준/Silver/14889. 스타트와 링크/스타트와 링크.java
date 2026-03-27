import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    
    static int N;
    static int[][] teamStatInfo;
    static boolean[] selected;
    static int result = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        teamStatInfo = new int[N][N];
        selected = new boolean[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                teamStatInfo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        makeTeam(0, 0);
        System.out.println(result);
    }
	
	private static void makeTeam(int index, int count) {
	    if (count == N / 2) {
	        calculateDifference();
	        return;
	    }
	    
	    for (int i = index; i < N; i++) {
	        selected[i] = true;
	        makeTeam(i + 1, count + 1);
	        selected[i] = false;
	    }
	}
	
	private static void calculateDifference() {
	    int startTeamStat = 0;
	    int linkTeamStat = 0;
	    
	    for (int i = 0; i < N; i++) {
	        for (int j = i + 1; j < N; j++) {
	            if (selected[i] && selected[j]) {
	                startTeamStat += teamStatInfo[i][j] + teamStatInfo[j][i];
	            } else if (!selected[i] && !selected[j]) {
	                linkTeamStat += teamStatInfo[i][j] + teamStatInfo[j][i];
	            }
	        }
	    }
	    
	    result = Math.min(result, Math.abs(startTeamStat - linkTeamStat));
	}
}
