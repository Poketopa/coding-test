import java.util.*;
class Solution {
    public int solution(String message, int[][] spoiler_ranges) {
        Set<Integer> set = new HashSet<>();
        int count = 0;
        for(int i=0;i<message.length();i++){
            if(message.charAt(i) == ' '){
                count++;
                continue;
            } 
            for(int j=0;j<spoiler_ranges.length;j++){
                if(spoiler_ranges[j][0] <= i
                  && i <= spoiler_ranges[j][1]){
                    set.add(count);
                }
            }
        }
        Set<String> stringSet = new HashSet<>();
        String[] split = message.split(" ");
        for(int i=0;i<split.length;i++){
            if(!set.contains(i)){
                stringSet.add(split[i]);
            }
        }
        List<Integer> list = new ArrayList<>(set);
        int answer = 0;
        for(int i : list){
            if(!stringSet.contains(split[i])){
                answer++;
                stringSet.add(split[i]);
            }
        }
        return answer;
    }
}