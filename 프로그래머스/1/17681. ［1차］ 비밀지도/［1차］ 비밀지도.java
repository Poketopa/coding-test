import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        Arrays.fill(answer,"");
        String[] map1 = new String[n];
        String[] map2 = new String[n];
        Arrays.fill(map1, "");
        Arrays.fill(map2, "");
        // 정수형을 바이너리 문자열로 변경
        for(int i=0;i<n;i++){
            for(int j=0;j<n-Integer.toBinaryString(arr1[i]).length();j++){
                map1[i]+="0";
            }
            for(int j=0;j<n-Integer.toBinaryString(arr2[i]).length();j++){
                map2[i]+="0";
            }
            map1[i] += Integer.toBinaryString(arr1[i]);
            map2[i] += Integer.toBinaryString(arr2[i]);
        }
        // {01001, 10110, 11100, 10010, 01011}
        //
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(map1[i].charAt(j) == '1' || map2[i].charAt(j) == '1'){
                    answer[i] += "#";
                }
                else{
                    answer[i] += " ";
                }
            }
        }
        return answer;
    }
}