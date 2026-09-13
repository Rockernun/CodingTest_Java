import java.util.*;

class Solution {
    public String solution(int n, int k, String[] cmd) {
        int[] up = new int[n];  
        int[] down = new int[n];
        for (int i = 0; i < n; i++) {
            up[i] = i - 1;
            down[i] = i + 1;
        }
        
        boolean[] deleted = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (String c : cmd) {
            char op = c.charAt(0);

            if (op == 'U') {
                int x = Integer.parseInt(c.split(" ")[1]);
                while (x-- > 0) {
                    k = up[k]; 
                } 
            } else if (op == 'D') {
                int x = Integer.parseInt(c.split(" ")[1]);
                while (x-- > 0) {
                    k = down[k];
                } 
            } else if (op == 'C') {
                deleted[k] = true;
                stack.push(k);

                int u = up[k];
                int d = down[k];
                
                if (u != -1) {
                    down[u] = d;
                }
                if (d != n) {
                    up[d] = u;
                }

                k = (d == n) ? u : d;
            } else {
                int restore = stack.pop();
                deleted[restore] = false;

                int u = up[restore], d = down[restore];

                if (u != -1) {
                    down[u] = restore;
                }
                if (d != n) {
                    up[d] = restore;
                }
            }
        }
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            sb.append(deleted[i] ? "X" : "O");
        }
        
        return sb.toString();
    }
}