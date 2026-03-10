import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        Integer[] rope = new Integer[N];
        for(int i = 0; i < N; i++){
            rope[i] = Integer.parseInt(br.readLine());
        }
        
        Arrays.sort(rope, Collections.reverseOrder());
    
        int count = 1;
        int max = 0;

        for(int i = 0; i < N; i++){
            max = Integer.max(rope[i]*count, max);
            count++;
        }
      
        System.out.println(max);
    }
}