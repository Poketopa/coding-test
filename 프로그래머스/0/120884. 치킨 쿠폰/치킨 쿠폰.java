class Solution {
    public int solution(int chicken) {
        int answer = 0;
        while(chicken>=10){
            chicken-=9;
            answer++;
        }
        return answer;
    }
}