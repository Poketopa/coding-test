import java.util.*;
class Solution {
    public int solution(int[] rank, boolean[] attendance) {
        int answer = 0;
        List<Integer> list = new ArrayList<>();
        for(int i=0;i<rank.length;i++){
            if(attendance[i]) list.add(rank[i]);
        }
        Collections.sort(list);
        for(int i=0;i<rank.length;i++){
            if(rank[i] == list.get(0)) answer += (i) * 10000;
            else if(rank[i] == list.get(1)) answer += (i) * 100;
            else if(rank[i] == list.get(2)) answer += (i);
        }
        return answer;
    }
}