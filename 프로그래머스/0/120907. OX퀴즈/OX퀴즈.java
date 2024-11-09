class Solution {
    public String[] solution(String[] quiz) {
        int math = 0;
        String[] answer = new String[quiz.length];
        for(int i=0;i<quiz.length;i++){
            // [3, -, 5, =, -3]
            String[] str = quiz[i].split(" ");
            int sum = Integer.valueOf(str[0]);
            for(int j=1;j<str.length;j++){
                if(str[j].equals("+")){
                    math = 1;
                }
                else if(str[j].equals("-")){
                    math = 0;
                }
                else if(str[j].equals("=")){
                    math = 2;
                }
                else{
                    if(math == 1){
                        sum+=Integer.valueOf(str[j]);
                    }
                    else if(math == 0){
                        sum-=Integer.valueOf(str[j]);
                    }
                    else if(math == 2){
                        if(sum==Integer.valueOf(str[j])){
                            answer[i] = "O";
                        }
                        else{
                            answer[i] = "X";
                        }
                    }
                }
            }
        }
        return answer;
    }
}