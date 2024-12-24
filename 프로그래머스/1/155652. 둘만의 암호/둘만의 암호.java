import java.util.*;

class Solution {
    public String solution(String s, String skip, int index) {
        char[] input = new char[s.length()];
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0;i<s.length();i++){
            input[i] = s.charAt(i);
        }
        for(int i=0;i<skip.length();i++){
            map.put(skip.charAt(i), 1);
        }
        // s문자열 돌면서 각각 index를 올린다
        // 이 때 skip에 포함되면 무시
        for(int i=0;i<input.length;i++){
            for(int j=0;j<index;j++){
                input[i] += 1;
                if(input[i]>'z'){
                    input[i] -= 'z'-'a'+1;
                }
                while(true){
                    if(map.containsKey(input[i])){
                        input[i]+=1;
                        if(input[i]>'z'){
                            input[i] -= 'z'-'a'+1;
                        }
                    }
                    else{
                        break;
                    }
                }
            }
        }
        String answer = new String(input);
        return answer;
    }
}