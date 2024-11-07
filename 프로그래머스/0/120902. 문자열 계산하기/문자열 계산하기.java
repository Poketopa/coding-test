class Solution {
    public int solution(String my_string) {
        String[] str = my_string.split(" ");
        int sum = 0;
        int isAdd = 1;
        for(int i=0;i<str.length;i++){
            if(str[i].equals("+")){
                isAdd = 1;
                continue;
            }
            else if(str[i].equals("-")){
                isAdd = 0;
                continue;
            }
            else{
                if(isAdd == 1){
                    sum+=Integer.valueOf(str[i]);
                }
                else{
                    sum-=Integer.valueOf(str[i]);
                }

            }
        }
        return sum;
    }
}