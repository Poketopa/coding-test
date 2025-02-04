class Solution {
    public int solution(int n, int[] money) {
        // 각 인덱스 n은 n의 값을 만들 수 있는 경우의 수
        int[] number = new int[n+1];
        // 0을 만들 수 있는 경우의 수 1
        number[0] = 1;

        // 동전의 종류만큼 반복
        for(int i=0;i<money.length;i++){
            for(int j=money[i];j<number.length;j++){
                // n원의 경우의 수 = 이전에 만들 수 있었던 경우의 수(number[money[i]]]) + 새로 만들 수 있는 경우의 수
                number[j] = number[j] + number[j - money[i]];
            }
        }
        return number[n];
    }
}