class Solution {
    public int[] solution(int[] emergency) {
        int[] answer = new int[emergency.length];
        int max = 0;
        int index=0;
        int counter = 1;
        for(int i=0;i<emergency.length;i++){
            for(int j=0;j<emergency.length;j++){
                if(max<emergency[j]){
                max = emergency[j]; 
                index = j;
                }
            }
            emergency[index] = 0;
            answer[index] = counter;
            counter++;
            max = 0;
            
        }
        return answer;
    }
}