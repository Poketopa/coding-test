class Solution {
    public int solution(int a, int b, int c, int d) {
        int[] array = new int[4];
        array[0] = a;
        array[1] = b;
        array[2] = c;
        array[3] = d;

        int count = 0;
        int sameNum = 0;
        for(int i=0;i<4;i++){
            for(int j=i+1;j<4;j++){
                if (array[i] == array[j]){
                    count++;
                    sameNum = array[i];
                }
            }
        }
        if (count == 0){
            int min = 7;
            for (int i=0;i<4;i++){
                if (array[i] < min){
                    min = array[i];
                }
            }
            return min;
        }
        // 2개 같을 때
        else if (count == 1){
            int number =1;
            for (int i =0;i<4;i++){
                if (array[i]!= sameNum){
                    number *= array[i];
                } 
            }
            return number;
        }
        else if(count ==2){
            int number = array[0];
            for(int i=1;i<4; i++){
                if (array[i]!=number){
                    return (array[i]+number) * Math.abs(array[i]-number);
                }
            }
        }
        else if(count == 3){
            for (int i =0;i<4;i++){
                if (array[i]!= sameNum){
                    return ((sameNum*10) + array[i]) * ((sameNum*10) + array[i]);
                }
            }
        }
        else{
            return 1111*sameNum;
        }


        

        int answer = 0;
        return answer;
    }
}