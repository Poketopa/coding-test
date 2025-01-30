class Solution {
    public String solution(String myString) {
        String answer = "";
        for(int i=0;i<myString.length();i++){
            char temp = myString.charAt(i);
            if(temp == 'a') answer += "A";
            else if('B'<=temp && temp<='Z'){
                answer += String.valueOf(Character.toLowerCase(temp));
            }
            else{
                answer += String.valueOf(temp);
            }
            
        }
        return answer;
    }
}