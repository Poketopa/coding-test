import java.util.*;
class Solution {
    public int solution(String before, String after) {
        String[] beforeStr = before.split("");
        String[] afterStr = after.split("");
        Arrays.sort(beforeStr);
        Arrays.sort(afterStr);
        for(int i=0;i<beforeStr.length;i++){
            if(!beforeStr[i].equals(afterStr[i])){
                return 0;
            }
        }
        return 1;
    }
}