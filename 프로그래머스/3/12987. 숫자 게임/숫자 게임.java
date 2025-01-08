import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int aIndex = 0;
        int bIndex = 0;
        int count = 0;
        x:
        for(int i=0;i<A.length;i++){
            while(bIndex != B.length){
                if(A[i]<B[bIndex]){
                    count++;
                    bIndex++;
                    continue x;
                }
                bIndex++;
            }
        }
        return count;
    }
}