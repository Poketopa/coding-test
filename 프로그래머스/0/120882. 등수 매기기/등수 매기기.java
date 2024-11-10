class Solution {
    public int[] solution(int[][] score) {
        int length = score.length;
        int lengthIndex = 0;
        int howmany = 0;
        int[] array = new int[score.length];
        int[] answer = new int[score.length];
        int index = 1;
        for(int i=0;i<score.length;i++){
            array[i] = ((score[i][0]+score[i][1]));
        }
        while(lengthIndex<length){


            int max = -100;
            howmany = 0;

            for(int i=0;i<array.length;i++){
                if(array[i]>max){
                    max = array[i];
                }
            }
            for(int i=0;i<array.length;i++){
                if(max == array[i]){
                    answer[i]=index;
                    array[i] = -1;
                    lengthIndex++;
                    howmany++;
                }
            }
            index+=howmany;
        }
        return answer;
    }
}