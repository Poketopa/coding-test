class Solution {
    public int solution(int a, int b, int n) {
        int answer = 0;
        while(true){
            if(n / a < 1) break;
            int temp = (n / a) * b;
            answer += temp;
            n = temp + (n % a);
        }
        return answer;
    }
}