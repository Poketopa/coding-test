class Solution {
    public int solution(String str1, String str2) {
        int length = str1.length();
        
        str1 = str1.replace(str2,"");
        
        if(str1.length() != length){
            return 1;
        }
        return 2;
        
    }
}