import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        boolean[] l = new boolean[n + 1];
        boolean[] r = new boolean[n + 1];
        
        for (int a : lost) l[a] = true;
        for (int b : reserve) r[b] = true;
        
        int same = 0;
        for (int i = 1; i <= n; i++) {
            if (l[i] && r[i]) {
                same++;
                l[i] = false;
                r[i] = false;
            }
        }
        
        int answer = n - lost.length + same;
        Arrays.sort(reserve);
        
        for (int s = 0; s < reserve.length; s++) {
            int currentStudent = reserve[s];
            if (r[currentStudent] && l[currentStudent]) continue;
            
            if (currentStudent == 1 && r[currentStudent] && l[currentStudent + 1]) {
                l[currentStudent + 1] = false;
                answer++;
            }
            
            if (currentStudent == n && r[currentStudent] && l[currentStudent - 1]) {
                l[currentStudent - 1] = false;
                answer++;
            }
            
            if (currentStudent > 1 && currentStudent < n && r[currentStudent]) {
                if (l[currentStudent - 1] && l[currentStudent + 1]) {
                    l[currentStudent - 1] = false;
                    answer++;
                } else if (l[currentStudent - 1] && !l[currentStudent + 1]) {
                    l[currentStudent - 1] = false;
                    answer++;
                } else if (l[currentStudent + 1] && !l[currentStudent - 1]) {
                    l[currentStudent + 1] = false;
                    answer++;
                }
            }
        }
        
        return answer;
    }
}