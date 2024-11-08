import java.util.*;
class Solution {
    public String solution(String polynomial) {
        int int1 = 0;
        int int2 = 0;
        
        polynomial = polynomial.replace(" ","");
        String[] str = polynomial.split("\\+");
        
        for(int i=0;i<str.length;i++){
            if(str[i].contains("x")){
                str[i] = str[i].replace("x","");
                if(str[i].length()==0){
                    int1+=1;
                }
                else{
                    int1+=Integer.valueOf(str[i]);
                }
            }
            else{
                int2+=Integer.valueOf(str[i]);
            }
        }
        String answer = "";
        if(int1!=0){
            if(int1!=1){
                answer+=int1;    
            }
            
            answer+="x";
        }
        if(int1!=0&&int2!=0){
            answer+=" + ";
        }
        if(int2!=0){
            answer+=int2;
        }
        return answer;
    }
}