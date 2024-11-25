class Solution {
    public int solution(int n) {
        String three = "";
        while(true){
            int remain = n%3;
            three += remain;
            n /= 3;
            if(n==0){
                break;
            }
        }
        int index =1;
        int sum=0;
        for(int i=three.length()-1;i>=0;i--){
            sum+=index*((int)three.charAt(i)-48);
            index *=3;
        }
        return sum;
    }
}