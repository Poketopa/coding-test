import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        Map<String, Set<String>> map = new HashMap<>();
        
        for(int i=0;i<clothes.length;i++){
            if(!map.containsKey(clothes[i][1])){
                map.put(clothes[i][1], new HashSet<>());
            }
            map.get(clothes[i][1]).add(clothes[i][0]);
            
        }
        int sum = 1;
        for(String i : map.keySet()){
            sum *= (map.get(i).size() + 1);
        }
        return sum-1;
    }
}