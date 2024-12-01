class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        for(int i=0;i<babbling.length;i++){
            if(babbling[i].length()!= babbling[i].replace("ayaaya","").length()){
                continue;
            }if(babbling[i].length()!= babbling[i].replace("yeye","").length()){
                continue;
            }
            if(babbling[i].length()!= babbling[i].replace("woowoo","").length()){
                continue;
            }
            if(babbling[i].length()!= babbling[i].replace("mama","").length()){
                continue;
            }
            babbling[i] = babbling[i].replace("aya", " ");
            babbling[i] = babbling[i].replace("ye", " ");
            babbling[i] = babbling[i].replace("woo", " ");
            babbling[i] = babbling[i].replace("ma", " ");
            babbling[i] = babbling[i].replace(" ", "");
            if(babbling[i].equals("")){
                answer++;
            }
        }
        return answer;
    }
}