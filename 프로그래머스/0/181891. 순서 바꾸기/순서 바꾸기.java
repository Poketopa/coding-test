class Solution {
    public int[] solution(int[] num_list, int n) {
        int temp = n;
        int index = 0;
        int[] answer = new int[num_list.length];
        while(n != num_list.length){
            answer[index] = num_list[n];
            index++;
            n++;
        }
        n=0;
        while(n!=temp){
            answer[index] = num_list[n];
            index++;
            n++;
        }
        return answer;
    }
}