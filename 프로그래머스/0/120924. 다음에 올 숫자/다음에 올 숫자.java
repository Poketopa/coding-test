class Solution {
    public int solution(int[] common) {
        int add=0;
        int mul=0;
        int index = 0;
        if(common[0]==0&&common[1]==0){
            return 0;
        }
        while(true){
            if(common[index]!=0){
                add = common[index+1]-common[index];
                mul = common[index+1]/common[index];
                break;
            }
            else{
                index++;
            }
        }

        if((common[common.length-1]-add)==common[common.length-2]){
            return common[common.length-1]+add;
        }
        else{
            return common[common.length-1]*mul;
        }
    }
}