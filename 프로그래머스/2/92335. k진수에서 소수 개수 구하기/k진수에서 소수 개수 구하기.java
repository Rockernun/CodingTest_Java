class Solution {
    public int solution(int n, int k) {
        String convertedNumber = convert(n, k);
        int count = 0;
        
        for (String s : convertedNumber.split("0")) {
            if (!s.isEmpty() && isPrime(Long.parseLong(s))) {
                count++;
            }
        }
        
        return count;
    }
    
    private String convert(int n, int k) {
        StringBuilder sb = new StringBuilder();
        
        while (n > 0) {
            sb.append(n % k);
            n /= k;
        }
        
        return sb.reverse().toString();
    }
    
    private boolean isPrime(long number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}