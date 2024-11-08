import java.util.*;

class Solution {
    public int solution(String[] spell, String[] dic) {
        for(int i=0;i<dic.length;i++){
            int count = 0;
            for(int j=0;j<spell.length;j++){
                if(dic[i].length() == dic[i].replace(spell[j],"").length()+1){
                    dic[i] = dic[i].replace(spell[j],"");
                    count++;
                }
            }
            if(count!=spell.length){
                dic[i]+="1";
            }
        }
        for(int i=0;i<dic.length;i++){
            if(dic[i].length()==0){
                return 1;
            }
        }
        return 2;
    }
}