import java.util.*;
import java.math.*;

class Solution {
    public int solution(String t, String p) {
        String[] str = t.split("");
        String cmp = "";

        int answer=0;

        for(int i=0;i<=str.length-p.length();i++){
            for(int j=i;j<i+p.length();j++){
                if(cmp.length()==0&&str[j].equals("0")){
                    continue;
                }
                cmp+=str[j];
            }
            if(cmp.length()==0){
                cmp+=0;
            }
            BigInteger bigint1 = new BigInteger(cmp);
            BigInteger bigint2 = new BigInteger(p);
            if(bigint1.compareTo(bigint2)<=0){
                answer++;
            }
            cmp = "";
        }
        return answer;
    }
}