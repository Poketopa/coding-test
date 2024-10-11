class Solution {
    public String solution(String s) {
        int strLen = s.length();
        int halfLen = strLen / 2;
        String result = "";
        if (strLen % 2 == 0) {
            result = (s.substring(halfLen-1,halfLen+1));
        }
        else{
            result = (s.substring(halfLen,halfLen+1));
        }
        return result;
    }
}