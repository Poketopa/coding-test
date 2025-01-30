class Solution {
    public int solution(int[] num_list) {
        if(num_list.length >10){
            int answer = 0;
            for(int i : num_list) answer += i;
            return answer;
        }
        else{
            int answer = 1;
            for(int i : num_list) answer *= i;
            return answer;
        }
    }
}