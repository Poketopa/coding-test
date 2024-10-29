class Solution {
    public int solution(int hp) {
        int sum = 0;
        sum += hp / 5;
        hp = hp % 5;
        sum += hp / 3;
        hp = hp%3;
        sum += hp;
        return sum;
    }
}