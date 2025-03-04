import java.util.*;
class Solution {
    public int[] solution(int n, String[] words) {
        Map<String, Integer> map = new HashMap<>();
        map.put(words[0], 1);
        for(int i=1;i<words.length;i++){
            // 끝말잇기 실패
            if(words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                return new int[]{(i % n) + 1, ((i + n)/n)};
            }
            map.put(words[i], map.getOrDefault(words[i], 0) + 1);
            if(map.get(words[i]) == 2){
                return new int[]{(i % n) + 1, ((i + n)/n)};
            }
        }
        return new int[]{0,0};
    }
}