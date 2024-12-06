import java.util.*;

class Solution {
    public int solution(int[] topping) {
        // 왼쪽 sum, 오른쪽 sum
        int sum = 0;
        HashMap<Integer, Integer> left = new HashMap<>();
        HashMap<Integer, Integer> right = new HashMap<>();

        // 오른쪽에 다 넣는다
        for(int i : topping){
            right.put(i, right.getOrDefault(i, 0)+1);
        }

        for(int i=0;i<topping.length;i++){
            left.put(topping[i], left.getOrDefault(topping[i], 0)+1);
            right.put(topping[i], right.getOrDefault(topping[i], 0)-1);
            if(right.get(topping[i])==0){
                right.remove(topping[i]);
            }
            if(left.size()==right.size()){
                sum ++;
            }
        }
        return sum;

    }
}