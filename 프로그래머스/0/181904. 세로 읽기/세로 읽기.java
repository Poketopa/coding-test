class Solution {
    public String solution(String my_string, int m, int c) {
        c--;
        String answer = "";
        while(c < my_string.length()){
            answer += my_string.charAt(c);
            c += m;
        }
        return answer;
    }
}