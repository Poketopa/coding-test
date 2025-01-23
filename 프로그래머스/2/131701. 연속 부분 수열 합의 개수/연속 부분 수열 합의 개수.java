import java.util.*;
import java.math.*;

class Solution {
    public int solution(int[] elements) {
        int answer = 0;
        HashMap<Integer, Boolean> map = new HashMap<>();
        int[] array = new int[elements.length * 2 +1];
        array[0] = 0;
        for(int i=0;i<2*elements.length;i++){
            array[i+1] = elements[i % elements.length];
        }
        for(int i=1;i<array.length;i++){
            array[i] += array[i-1];
        }

        for(int i=0;i<array.length/2;i++){
            for(int j=1;j<array.length/2 + 1;j++){
                int sum = array[i+j] - array[i];
                if(map.containsKey(sum)){
                    continue;
                }
                else {
                    map.put(sum, true);
                    answer++;
                }
            }
        }
        return answer;

    }
}