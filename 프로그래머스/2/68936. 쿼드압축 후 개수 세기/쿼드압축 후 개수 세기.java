import java.util.*;

class Solution {
    public int[] solution(int[][] arr) {
        int length = arr.length;
        int[] answer = new int[2];

        // 크기가 1일 때까지
        while(length != 1){
            // 1. 0부터 arr.length 까지 i += length for문 반복
            // 2. 범위가 모두 같으면 -1변환 / 이때 숫자 +1
            // 3. length 절반으로 나누기
            // 3.
            for(int i=0;i<arr.length;i+=length){
                x :
                for(int j=0;j<arr.length;j+=length){
                    // 이미 압축 됐으면
                    if(arr[i][j] == -1) continue;
                    int firstNum = arr[i][j];

                    for(int k=i;k<i+length;k++){
                        for(int l = j;l<j+length;l++){
                            // 다르면
                            if(arr[k][l] != firstNum) continue x;
                        }
                    }
                    // 만약 다 똑같으면
                    answer[firstNum]++;
                    for(int k=i;k<i+length;k++){
                        for(int l = j;l<j+length;l++){
                            arr[k][l] = -1;
                        }
                    }

                }
            }
            length /= 2;
        }
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr.length;j++){
                if(arr[i][j] == 0) answer[0]++;
                else if(arr[i][j] == 1) answer[1]++;
                else continue;
            }
        }
        return answer;
    }
}