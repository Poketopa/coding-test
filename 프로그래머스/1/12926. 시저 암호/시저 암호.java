class Solution {
    public String solution(String s, int n) {
        String answer = "";
        char test= 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)==' '){
                answer+=' ';
                continue;
            }
            test = (char)(s.charAt(i)+n);
            if(s.charAt(i)<'a'){
                while(test>'Z'){
                    test-=26;
                }
            }
            else{
                while(test>'z'){
                    test-=26;
                }
            }
            answer+=test;
        }
        return answer;
    }
}