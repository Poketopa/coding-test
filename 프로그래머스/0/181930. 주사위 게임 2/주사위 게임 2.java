class Solution {
    public int solution(int a, int b, int c) {
        int score = 0;
        if(a==b) score++;
        if(b==c) score++;
        if(a==c) score++;
        if(score==0) return a+b+c;
        if(score==1) return (a*a+b*b+c*c) * (a+b+c);
        return ((int)Math.pow(a, 3) + (int)Math.pow(b, 3) + (int)Math.pow(c,3)) * ((a*a+b*b+c*c) * (a+b+c));
    }
}