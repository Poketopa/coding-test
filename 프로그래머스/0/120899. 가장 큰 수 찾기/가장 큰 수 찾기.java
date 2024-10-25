class Solution {
    public int[] solution(int[] array) {
        int max = -1;
        int index = 0;
        for(int i=0;i<array.length;i++){
            if (array[i]>max){
                max = array[i];
                index = i;
            }
        }
        int[] answer = {max,index};
        return answer;
    }
}