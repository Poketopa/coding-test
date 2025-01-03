class Solution {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        // n진법
        // t번째까지 구해놓고
        // m명 참가 (m번째마다 말해야함)
        // 튜브의 순서 p
        String number = "";
        for(int i=0;i<=t*m;i++){
            number+=Integer.toString(i, n);
        }
        String[] split = new String[number.length()];
        for(int i=0;i<number.length();i++){
            if('a'<=number.charAt(i) && number.charAt(i)<='z'){
                char temp = number.charAt(i);
                temp -= 32;
                split[i] = String.valueOf(temp);
            }
            else{
                split[i] = String.valueOf(number.charAt(i));
            }
        }
        int index = 1;
        // 문자열 한글자씩 나눔
        for(int i=0;i<m*t;i++){
            if(index == p){
                answer+=split[i];
            }
            index++;
            if(index>m){
                index =1;
            }
        }
        return answer;
    }
}