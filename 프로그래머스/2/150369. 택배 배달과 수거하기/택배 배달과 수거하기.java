class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int deliveryIdx = n - 1;
        int pickupIdx = n - 1;
            
        while (true) {
            deliveryIdx = findLastHouse(deliveries, deliveryIdx);
            pickupIdx = findLastHouse(pickups, pickupIdx);
            int lastHouse = Math.max(deliveryIdx, pickupIdx);

            if (lastHouse == -1) {
                break;
            }

            answer += (long) (lastHouse + 1) * 2;  // 가장 먼 집까지 왕복
            int delivery = 0;
            int pickup = 0;

            // 갈 때: 배달이 남은 가장 먼 집부터, 트럭이 가득 차면 멈춤
            for (int i = deliveryIdx; i >= 0 && delivery < cap; i--) {
                if (deliveries[i] <= (cap - delivery)) {
                    delivery += deliveries[i];
                    deliveries[i] = 0;
                } else {
                    deliveries[i] -= (cap - delivery);
                    delivery += (cap - delivery);
                }
            }

            // 올 때: 수거가 남은 가장 먼 집부터, 트럭이 가득 차면 멈춤
            for (int i = pickupIdx; i >= 0 && pickup < cap; i--) {
                if (pickups[i] <= (cap - pickup)) {
                    pickup += pickups[i];
                    pickups[i] = 0;
                } else {
                    pickups[i] -= (cap - pickup);
                    pickup += (cap - pickup);
                }
            }
        }
        
        return answer;
    }
    
    private int findLastHouse(int[] houses, int idx) {
        while (idx >= 0 && houses[idx] == 0) {
            idx--;
        }
        
        return idx;
    }
}