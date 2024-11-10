class Solution {
    public int solution(String A, String B) {
        int count=0;
        if(A.equals(B)){
            return 0;
        }
        for(int i = A.length()-1;i>0;i--){
            String str ="";
            count++;
            for(int j=i;j<i+A.length();j++){
                str+=A.charAt(j%A.length());
            }
            if(str.equals(B)){
                return count;
            }
        }
        return -1;
    }
}