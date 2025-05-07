class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i=0;i<myString.length();i++){
            if('a'<=myString.charAt(i) && myString.charAt(i) <= 'z'){
                answer += (char)('A' + myString.charAt(i) - 'a');
            }
            else answer += myString.charAt(i);
        }
        return answer;
    }
}