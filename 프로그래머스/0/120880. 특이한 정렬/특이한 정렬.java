class Solution {
    public int[] solution(int[] numlist, int n) {
        
        int index = 0;
        int[] answer = new int[numlist.length];
        for(int i=0;i<answer.length;i++){
            int min = 99999;
            for(int j=0;j<answer.length;j++){
                if(numlist[j] == 0){
                    continue;
                }
                // n이랑 차이나는 값이 min보다 작으면
                if(Math.abs(numlist[j]-n)<=Math.abs(min)){
                    // 그 값이 음수이고 양수 min과 같을 시에 무시
                    if(-(numlist[j]-n)==min && (numlist[j]-n)<min){
                        continue;
                    }
                    // min값에 차이나는 값 넣음
                    // 해당 인덱스 기억
                    else{
                        min = (numlist[j]-n);
                        index = j;
                    }
                }    
                
            }
            answer[i] = numlist[index];
            numlist[index] = 0;
            
        }
        return answer;
    }
}