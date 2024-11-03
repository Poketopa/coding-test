class Solution {
    public int solution(int[] array, int n) {
        int up = n;
        int down = n;
        while(true){
            for(int i:array){
                if(i==down){
                    return i;
                }
            }
            for(int i:array){
                if(i==up){
                    return i;
                }
            }
            up++;
            down--;
        }
    }
}