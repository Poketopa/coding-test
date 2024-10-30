import java.util.*;

class Solution {
    public String solution(String rsp) {
        List<String> list = new ArrayList<>();
        for(int i=0;i<rsp.length();i++){
            if(rsp.charAt(i) == '2'){
                list.add("0");
            }
            else if(rsp.charAt(i) == '0'){
                list.add("5");
            }
            else{
                list.add("2");
            }
        }
        String answer;
        answer = String.join("",list);
        return answer;
    }
}