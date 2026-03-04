import java.util.Scanner;

public class Main {
   public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       int input = sc.nextInt();
       
       int count = 0;
      
      int fiveHundredWon = (int) input / 5;
      int exchange = input - 5 * fiveHundredWon;
       
      if (input == 3 || input == 1) {
          System.out.println(-1);
          return;
      }

      if (exchange % 2 == 0) {
          if (exchange == 0) {
              System.out.println(fiveHundredWon);
              return;
          }
          
          count += fiveHundredWon;
          count += (int) exchange / 2;
          System.out.println(count);
      }
      
      if (exchange % 2 == 1) {
          count += fiveHundredWon - 1;
          count += (int) (exchange + 5) / 2;
          System.out.println(count);
      }
   }
}