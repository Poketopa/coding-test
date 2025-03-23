class Solution {
    public int solution(String number) {
        long answer = 0;
        for(int i=0;i<number.length();i++){
            answer += number.charAt(i) - '0';
            answer %= 9;
        }
        return (int)answer;
    }
}