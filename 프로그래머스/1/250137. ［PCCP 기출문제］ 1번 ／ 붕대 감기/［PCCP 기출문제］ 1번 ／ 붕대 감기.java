import java.util.*;

class Solution {
    
    Map<Integer, Integer> attackInfo = new HashMap<>();
    
    public int solution(int[] bandage, int health, int[][] attacks) {
        int continousHeal = bandage[0];
        int increaseHp = bandage[1];
        int bonusHp = bandage[2];
        int maxHealth = health;      
        int lastAttack = attacks[attacks.length - 1][0];
        int count = 0;
        
        for (int[] attack : attacks) {
            attackInfo.put(attack[0], attack[1]);
        }

        for (int i = 1; i <= lastAttack; i++) {
            count++;
            // 공격을 받은 경우
            if (attackInfo.keySet().contains(i)) {
                if ((health - attackInfo.get(i)) <= 0) {
                    return -1;
                }
                health -= attackInfo.get(i);
                count = 0;
            } 
            
            // 연속 회복에 성공한 경우 
            if (count == continousHeal) {
                if ((health + bonusHp) > maxHealth) {
                    health = maxHealth;
                }
                health += bonusHp;
                if (continousHeal == 1) {
                    if ((health + increaseHp) > maxHealth) {
                        health = maxHealth;
                    } 
                    health += increaseHp;
                }
                count = 0;
            } 
            
            // 일반적인 경우
            if (!attackInfo.keySet().contains(i) && count != continousHeal) {
                health += increaseHp;
                if ((health + increaseHp) > maxHealth) {
                    health = maxHealth;
                }
            }
        }
        return health;
    }
}