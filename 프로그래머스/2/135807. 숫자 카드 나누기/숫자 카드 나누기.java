class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int min = Integer.MAX_VALUE;
        for(int i : arrayA){
            if(min>i){
                min = i;
            }
        }
        int aMin = min;
        min = Integer.MAX_VALUE;
        for(int i : arrayB){
            if(min>i){
                min = i;
            }
        }
        int bMin = min;
        int fail = 0;
        int num1 = 0;
        int num2 = 0;
        // b는 안나눠지고 a는 나눠지는 상황
        // b가 나눠지면 탈출
        for(int i=aMin;i>0;i--){
            fail = 0;
            for(int j=0;j<arrayA.length;j++){
                // a가 나눠지지 않으면
                if(arrayA[j] % i != 0){
                    fail = 1;
                    break;
                }
                // b가 나눠지면
                if(arrayB[j] % i == 0){
                    fail = 1;
                    break;
                }
            }
            // 성공
            if(fail == 0){
                num1 = i;
                break;
            }
        }
        for(int i=bMin;i>0;i--){
            fail = 0;
            for(int j=0;j<arrayA.length;j++){
                // a가 나눠지지 않으면
                if(arrayB[j] % i != 0){
                    fail = 1;
                    break;
                }
                // b가 나눠지면
                if(arrayA[j] % i == 0){
                    fail = 1;
                    break;
                }
            }
            // 성공
            if(fail == 0){
                num2 = i;
                break;
            }
        }
        int answer = 0;
        if(num1>num2){
            answer = num1;
            return answer;
        }
        else{
            return num2;
        }
    }
}