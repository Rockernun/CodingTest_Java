import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int room = sc.nextInt(); 

		int[] studentArr = new int[room]; 
		
		for (int i = 0; i < studentArr.length; i++) {
            studentArr[i] = sc.nextInt();
        }
		
		int mainDirector = sc.nextInt();
        int subDirector = sc.nextInt();
		
		long result = room;   
		for (int i = 0; i < studentArr.length; i++) {
		    studentArr[i] = studentArr[i] - mainDirector;
		    if (studentArr[i] <= 0) {
		        continue;
		    } else if (studentArr[i] <= subDirector) {
		        result++;
		    } else {
		        if (studentArr[i] % subDirector == 0) {
		            result += studentArr[i] / subDirector;
		        } else {
		            result += (studentArr[i] / subDirector) + 1;
		        }
		    }
		}
		
		System.out.println(result);
	}
}
