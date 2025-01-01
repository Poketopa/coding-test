import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int sum = sequence[0];
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int a = 0;
        int b = 0;

        while(end<sequence.length){
            while(sum<k){
                end++;
                if(end>=sequence.length) break;
                sum+=sequence[end];
            }
            if(sum==k){
                if(end-start<min){
                    min = end-start;
                    a = start;
                    b = end;
                }
                sum-=sequence[start];
                start++;
            }
            else{
                while(sum>k) {
                    sum -= sequence[start];
                    start++;
                }
            }
        }
        return new int[]{a, b};
    }
}