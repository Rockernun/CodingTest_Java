import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

// 6 
// 1 2 3 4 5 6
// 2 1 1 1

public class Main {
    
    static int N;
    static int max = Integer.MIN_VALUE;
	static int min = Integer.MAX_VALUE;
    static int[] numbers;
    static int[] operators;
    
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer numbersInput = new StringTokenizer(br.readLine());
		StringTokenizer operatorsInput = new StringTokenizer(br.readLine());
		
		numbers = new int[N];
		operators = new int[4];
		
		// 숫자 배열 초기화
		for(int i = 0; numbersInput.hasMoreTokens(); i++) {
			numbers[i] = Integer.parseInt(numbersInput.nextToken());
		}
		
		// 연산자 배열 초기화
		for(int i = 0; operatorsInput.hasMoreTokens(); i++) {
			operators[i] = Integer.parseInt(operatorsInput.nextToken());
		}
		
		dfs(1, numbers[0]);
		System.out.println(max);
		System.out.println(min);
	}
	
	private static void dfs(int depth, int number) {
	    if (depth == N) {
	        max = Math.max(number, max);
	        min = Math.min(number, min);
	        return;
	    }
	    
	    for (int i = 0; i < 4; i++) {
	        if (operators[i] > 0) {
	            operators[i] = operators[i] - 1;
	            
	            if (i == 0) {
	                dfs(depth + 1, number + numbers[depth]);
	            } else if (i == 1) {
	                dfs(depth + 1, number - numbers[depth]);
	            } else if (i == 2) {
	                dfs(depth + 1, number * numbers[depth]);
	            } else if (i == 3) {
	                dfs(depth + 1, number / numbers[depth]);
	            }
	            
	            // 백트래킹
	            operators[i] = operators[i] + 1;
	        }
	    }
	}
}
