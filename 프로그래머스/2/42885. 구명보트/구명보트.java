import java.util.Arrays;

class Solution {
    public int solution(int[] people, int limit) {
        int boat = 0;
        Arrays.sort(people);
        int left = 0;
        int right = people.length - 1;
        
        while (left <= right) {
            int light = people[left];
            int heavy = people[right];
            
            if (light + heavy > limit) {
                right--;
                boat++;
            } else {
                left++;
                right--;
                boat++;
            } 
        }
        
        return boat;
    }
}