class Solution {
    public int solution(int[] sides) {
        int max = 0;
        int index = 0;
        for(int i=0;i<3;i++){
            if(max < sides[i]){
                max = sides[i];
                index = i;
            }
        }
        int sum=0;
        for(int i=0;i<3;i++){
            if(index != i){
                sum+= sides[i];
            }
        }
        if(sum>max){
            return 1;
        }
        else{
            return 2;
        }
    }
}