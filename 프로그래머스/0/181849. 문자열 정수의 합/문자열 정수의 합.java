class Solution {
    public int solution(String num_str) {
        String[] temp = num_str.split("");
        int answer = 0;
        for(int i=0;i<temp.length;i++){
            answer += Integer.valueOf(temp[i]);
        }
        return answer;
    }
}