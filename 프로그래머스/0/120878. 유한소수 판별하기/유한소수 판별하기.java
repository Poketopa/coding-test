class Solution {
    public int solution(int a, int b) {
        if(a==b){
            return 1;
        }
        int count=0;
        for(int i=2;i<=a;i++){
            if(a%i==0&&b%i==0){
                a/=i;
                b/=i;
                i=2;
            }
        }
        if(b==2){
            return 1;
        }
        for(int i=2;i<=b;i++){
            if(i%2==0 ||i%5==0){
                continue;
            }
            else{
                if(b%i==0){
                    count++;
                }

            }
        }
        if(count>0){
            return 2;
        }
        else{
            return 1;
        }
    }
}