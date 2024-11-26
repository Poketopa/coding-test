import java.util.*;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        int index1 = 0;
        int index2 = 0;
        int indexAns = 0;
        while(indexAns!=goal.length){
            if(index1<cards1.length && goal[indexAns].equals(cards1[index1])){
                index1++;
                indexAns++;
                continue;
            } else if (index2<cards2.length && goal[indexAns].equals(cards2[index2])) {
                index2++;
                indexAns++;
                continue;
            }
            else{
                return "No";
            }
        }
        return "Yes";
    }
}