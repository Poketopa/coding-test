
import java.util.*;

class Solution {
    public String solution(String bin1, String bin2) {
        if(bin1.length()<bin2.length()) {
            String swap = bin1;
            bin1 = bin2;
            bin2 = swap;
        }
        // bin1이 더 길다
        String[] str1 = bin1.split("");
        String[] str2 = bin2.split("");

        int[] int1 = new int[str1.length];
        int[] int2 = new int[str2.length];

        for(int i=0;i<str1.length;i++) {
            int1[i] = Integer.valueOf(str1[i]);
        }
        for(int i=0;i<str2.length;i++) {
            int2[i] = Integer.valueOf(str2[i]);
        }
        String answer = "";
        // 정수 배열에 넣었음
        // int1 에 더하
        for(int i=1;i<=int2.length;i++) {
            int1[int1.length-i]+=int2[int2.length-i];
        }
        for(int i = int1.length-1;i>=0;i--){
            if(int1[i]>1) {
                if(i ==0){
                    answer+=1;
                    int1[i] %= 2;
                }
                else{
                    // 길이 같은경우 1넣어놓음
                    int1[i-1]+=1;
                    int1[i] %= 2;
                }

            }
        }

        for(int i=0;i<int1.length;i++) {
            answer+=int1[i];
        }
        return answer;


    }
}