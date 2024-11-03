class Solution {
    public String solution(int age) {
        String str = String.valueOf(age);
        String answer = "";
        for(int i=0;i<str.length();i++){
            answer+=(char)(str.charAt(i)+49);
        }
        
        return answer;
    }
}