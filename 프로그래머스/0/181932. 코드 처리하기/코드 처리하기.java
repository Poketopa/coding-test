class Solution {
    public String solution(String code) {
        String answer = "";
        int mode = 0;
        for(int i=0;i<code.length();i++){
            if(code.charAt(i) == '1') {
                if(mode == 1) mode = 0;
                else mode = 1;
                continue;
            }
            if(mode == 0){
                if(i%2 == 0) answer += String.valueOf(code.charAt(i));
            }
            else{
                if(i%2 == 1) answer += String.valueOf(code.charAt(i));
            }
        }
        if(answer.length() == 0) return "EMPTY";
        return answer;
    }
}