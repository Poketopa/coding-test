class Solution {
    public int solution(String s) {
        int answer;
        if(s.charAt(0) == '-'){
            answer = Integer.parseInt(s.substring(1,s.length()));
            return -answer;
        }
        else if (s.charAt(0) == '+'){
            answer = Integer.parseInt(s.substring(1,s.length()));
            return answer;
        }
        else{
            answer = Integer.parseInt(s);
            return answer;
        }
    }
}