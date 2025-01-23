import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] money) {
        // 3개인 경우
        if(money.length == 3) return Math.max(Math.max(money[0],money[2]), money[1]);
        else if(money.length == 4) return Math.max(money[0]+money[2], money[1]+money[3]);

        int[] arr1 = money.clone();
        int[] arr2 = money.clone();
        int index1 = 3;
        int index2 = 4;

        arr1[2]+=arr1[0];
        int max1 = arr1[2];
        arr2[3]+=arr2[1];
        int max2 = arr2[3];

        while(true){
            arr1[index1] += Math.max(arr1[index1-2], arr1[index1-3]);
            max1 = Math.max(max1, Math.max(arr1[index1], arr1[index2-1]));
            if(index1 == arr1.length-2) break;
            index1++;
        }

        while(true){
            arr2[index2] += Math.max(arr2[index2-2], arr2[index2-3]);
            max2 = Math.max(max2, Math.max(arr2[index2], arr2[index2-1]));
            if(index2 == arr2.length-1) break;
            index2++;
        }

        return Math.max(max1, max2);
    }
}