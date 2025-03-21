class Solution {
    public int solution(String my_string, String target) {
        if(my_string.length() != my_string.replace(target,"").length()) return 1;
        else return 0;
    }
}