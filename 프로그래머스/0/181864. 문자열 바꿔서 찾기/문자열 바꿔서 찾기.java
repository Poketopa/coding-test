class Solution {
    public int solution(String myString, String pat) {
        int length = myString.length();
        myString = myString.replace("A", "C");
        myString = myString.replace("B", "D");
        myString = myString.replace("C", "B");
        myString = myString.replace("D", "A");
        myString = myString.replace(pat, "");
        if(length != myString.length()) return 1;
        return 0;
    }
}