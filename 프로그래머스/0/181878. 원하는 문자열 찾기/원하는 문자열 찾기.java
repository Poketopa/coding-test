class Solution {
    public int solution(String myString, String pat) {
        myString = myString.toLowerCase();
        pat = pat.toLowerCase();
        int prev = myString.length();
        int next = myString.replace(pat, "").length();
        if(prev != next) return 1;
        else return 0;
    }
}