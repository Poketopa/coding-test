import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        int answer = 0;
        Arrays.sort(strings, (a, b)->{
           if(a.charAt(n)<b.charAt(n)) return -1;
            else if(a.charAt(n)>b.charAt(n)) return 1;
            else{
                return a.compareTo(b);
            }
        });
        return strings;
    }
}