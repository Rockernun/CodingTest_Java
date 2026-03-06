import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int N = Integer.parseInt(input.split(" ")[0]);
		int K = Integer.parseInt(input.split(" ")[1]);
		
		List<Integer> coinList = new ArrayList<>();
		
		for (int i = 0; i < N; i++) {
		    coinList.add(sc.nextInt());
		}
		
		Collections.reverse(coinList);
		int count = 0;
		
		for (int coin : coinList) {
		    if (K == 0) {
                break;
            }
		    
		    if (coin > K) {
		        continue;
		    }
		    
		    count += (int) K / coin;
		    K = K - (int) (K / coin) * coin;
		}
		
		System.out.println(count);
	}
}