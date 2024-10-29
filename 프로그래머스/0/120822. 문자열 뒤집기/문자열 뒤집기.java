class Solution {
    public String solution(String my_string) {
        char words[] = my_string.toCharArray();
        char swap;
        for(int i=0;i<words.length/2;i++){
            swap = words[i];
            words[i] = words[words.length-1-i];
            words[words.length-1-i] = swap;
        }
        String answer = new String(words);
        return answer;
    }
}