import java.util.*;

class Solution {
    public int solution(int[] numbers) {
        List<Integer> list = new ArrayList<>();
        for(int i:numbers){
            list.add(i);
        }
        int max1 = Collections.max(list);
        list.remove(Integer.valueOf(max1));
        int max2 = Collections.max(list);
        return max1*max2;
    
    }
}