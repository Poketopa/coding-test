class Solution {
    public int solution(int a, int b) {
        String num1 = String.valueOf(a);
        String num2 = String.valueOf(b);
        String num3 = "";
        num3+=num1;
        num3+=num2;
        int sum = Integer.valueOf(num3);
        if(sum>a*b*2){
            return sum;
        }
        else{
            return a*b*2;
        }
    }
}