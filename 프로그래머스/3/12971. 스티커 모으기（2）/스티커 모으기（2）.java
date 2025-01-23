import java.util.*;
import java.math.*;

class Solution {
    public int solution(int sticker[]) {
        if(sticker.length == 1) return sticker[0];
        else if (sticker.length == 2) return Math.max(sticker[0], sticker[1]);
        else if(sticker.length == 3) return Math.max(sticker[0]+sticker[2], sticker[1]);

        int[] arr1 = sticker.clone();
        int[] arr2 = sticker.clone();
        // 1번째를 고르는 경우, 2번째를 고르는 경우 나누기

        // 1번째를 고르는 경우
        int max1 = 0;
        arr1[2] += arr1[0];
        int index = 3;
        while(true){
            arr1[index] += Math.max(arr1[index-2], arr1[index-3]);
            max1 = Math.max(arr1[index], arr1[index-1]);
            if(index == arr1.length-2) break;
            index++;

        }

        // 2번째를 고르는 경우
        int max2 = 0;
        arr2[3] += arr2[1];
        int index2 = 4;
        while(true){
            arr2[index2] += Math.max(arr2[index2-2], arr2[index2-3]);
            max2 = Math.max(arr2[index2], arr2[index2-1]);
            if(index2 == arr1.length-1) break;
            index2++;

        }


        return Math.max(max1, max2);
    }
}