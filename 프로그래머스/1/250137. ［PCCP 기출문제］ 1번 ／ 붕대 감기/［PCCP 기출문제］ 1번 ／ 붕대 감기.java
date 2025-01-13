import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        // bandage[몇초동안, 초당, 성공하면 보너스]
        // attacks[공격 시간, 피해량]
        int hp = health;

        int healTime = bandage[0];
        int healPerSec = bandage[1];
        int healBonus = bandage[2];

        int attackIndex = 0;
        int healStack = 0;
        // 마지막 공격까지 반복
        for(int i=1;i<=attacks[attacks.length-1][0];i++){
            if(attackIndex==attacks.length) break;
            //공격 당하면 마이너스
            if(i == attacks[attackIndex][0]){
                healStack = 0;
                health -= attacks[attackIndex][1];
                attackIndex++;
                if(health<=0) return -1;
                else continue;
            }
            healStack++;
            if(healStack == healTime){
                health += (healPerSec + healBonus);
                healStack = 0;
            }
            else{
                health += healPerSec;
            }
            if(health>hp) health = hp;
        }
        return health;
    }
}