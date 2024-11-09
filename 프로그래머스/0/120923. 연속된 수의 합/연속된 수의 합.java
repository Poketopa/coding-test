class Solution {
    public int[] solution(int num, int total) {
        int index = -num;
        int sum=0;
        int[] answer = new int[num];
        while(true){
            for(int i=0;i<num;i++){
                sum+= index+i;
            }
            if(sum==total){
                for(int i=0;i<answer.length;i++){
                    answer[i] = index+i;
                }
                break;
            }
            else{
                sum=0;
                index++;
            }
            
        }
        return answer;
    }
}