class Solution {
    public int solution(int slice, int n) {
        int answer = (n / (slice))+1;
        if(n%slice == 0){
            answer --;
        }
        return answer;
    }
}