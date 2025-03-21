class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {

        int maxHealth = health;
        int nowHealth = health;

        int attacksIndex = 0;
        int healingSeq = 0;

        // 1초씩 증가(마지막 공격까지)
        for (int i = 1; i <= attacks[attacks.length-1][0]; i++) {

            int attackTime = attacks[attacksIndex][0];
            int damage = attacks[attacksIndex][1];

            // 공격이면
            if(i == attackTime) {
                // 캐릭터 사망
                if(nowHealth <= damage) {
                    return -1;
                }
                
                nowHealth -= damage;
                
                attacksIndex++;
                healingSeq = 0;
                continue;
            }

            // 최대 체력이면 통과
            if(maxHealth <= nowHealth) {
                healingSeq = 0;
            }
            else {
                healingSeq++;
                // 초당 치료량 적용
                nowHealth += bandage[1];

                // 마지막 치료이면 추가 치료량 적용
                if(healingSeq == bandage[0]) {
                    nowHealth += bandage[2];
                    healingSeq = 0;
                }

                // 최대 체력보다 크면 안됨
                if(nowHealth > maxHealth) {
                    nowHealth = maxHealth;
                }
            }
        }

        return nowHealth;
    }
}