class Solution {
    public int solution(int num, int k) {
        String[] str = String.valueOf(num).split("");
        for(int i=0;i<str.length;i++){
            if(str[i].equals(String.valueOf(k))){
                return i+1;
            }
        }
        return -1;
        
    }
}