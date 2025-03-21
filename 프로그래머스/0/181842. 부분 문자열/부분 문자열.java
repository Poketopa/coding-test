class Solution {
    public int solution(String str1, String str2) {
        if(str2.length() != str2.replace(str1, "").length()) return 1;
        else return 0;
    }
}