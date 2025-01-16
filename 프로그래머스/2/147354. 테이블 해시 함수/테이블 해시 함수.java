import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, (a, b)->{
            if(a[col-1]<b[col-1]) return -1;
            else if(a[col-1]>b[col-1]) return 1;
            else{
                if(a[0]<b[0]) return 1;
                else if(a[0]>b[0]) return -1;
                else return 0;
            }
        });

        int answer = 0;
        for(int i = row_begin; i<=row_end;i++){
            int sum = 0;
            for(int j=0;j<data[0].length;j++){
                sum += data[i-1][j] % i;
            }
            answer ^= sum;
        }
        return answer;
    }
}