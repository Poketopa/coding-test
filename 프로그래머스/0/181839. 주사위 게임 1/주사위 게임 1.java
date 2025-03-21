class Solution {
    public int solution(int a, int b) {
        if(a%2==0 && b%2==0) return Math.abs(a-b);
        else if((a%2==0 && b%2==1)||(a%2==1 && b%2==0)) return (a+b) * 2;
        else return (a*a) + (b*b);
    }
}