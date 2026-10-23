class Solution {
    
    public String solution(String play_time, String adv_time, String[] logs) {
        int play = parseTimeToSecond(play_time);
        int adv = parseTimeToSecond(adv_time);

        long[] viewers = new long[play + 1];
        
        for (String log : logs) {
            String[] twoClock = log.split("-");
            viewers[parseTimeToSecond(twoClock[0])]++;
            viewers[parseTimeToSecond(twoClock[1])]--;
        }
        
        for (int t = 1; t < play; t++) viewers[t] += viewers[t - 1];
        
        long[] prefix = new long[play + 1];
        for (int t = 0; t < play; t++) prefix[t + 1] = prefix[t] + viewers[t];
        
        long max = -1;
        int result = 0;
        
        for (int s = 0; s <= play - adv; s++) {
            long total = prefix[s + adv] - prefix[s];
            if (total > max) { 
                max = total;
                result = s;
            }
        }
        
        return String.format("%02d:%02d:%02d", result / 3600, result % 3600 / 60, result % 60);
    }
    
    private int parseTimeToSecond(String time) {
        String[] split = time.split(":");
        int second = 0;
        second += Integer.parseInt(split[0]) * 60 * 60;
        second += Integer.parseInt(split[1]) * 60;
        second += Integer.parseInt(split[2]);
        return second;
    }
}