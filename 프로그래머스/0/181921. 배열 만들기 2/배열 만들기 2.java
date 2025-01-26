import java.util.*;
class Solution {
    public int[] solution(int l, int r) {
        List<Integer> list = new ArrayList<>();
        for(int i=1;i<1000000;i++){
            String temp = Integer.toBinaryString(i);
            String temp2 = "";
            for(int j=0;j<temp.length();j++){
                if(temp.charAt(j) == '1') temp2 += '5';
                else temp2 += '0';
            }
            int num = Integer.valueOf(temp2);
            if(l<=num && num <= r)
                list.add(num);
            else if(num > r) break;
        }
        if(list.size() == 0) return new int[] {-1};
        else {
            int[] answer = new int[list.size()];
            for(int i=0;i<answer.length;i++) answer[i] = list.get(i);
            return answer;
        }
    }
}