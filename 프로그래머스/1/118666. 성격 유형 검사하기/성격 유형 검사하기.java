import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int[] mbti = new int[4];
        for(int i=0;i<survey.length;i++){
            if(survey[i].equals("RT")) mbti[0] += -4 + choices[i];
            if(survey[i].equals("TR")) mbti[0] += 4 - choices[i];
            if(survey[i].equals("CF")) mbti[1] += -4 + choices[i];
            if(survey[i].equals("FC")) mbti[1] +=4 - choices[i];
            if(survey[i].equals("JM")) mbti[2] += -4 + choices[i];
            if(survey[i].equals("MJ")) mbti[2] += 4 - choices[i];
            if(survey[i].equals("AN")) mbti[3] += -4 + choices[i];
            if(survey[i].equals("NA")) mbti[3] += 4 - choices[i];
        }
        String answer = "";
        if(mbti[0]<=0) answer += "R";
        else answer += "T";
        if(mbti[1]<=0) answer += "C";
        else answer += "F";
        if(mbti[2]<=0) answer += "J";
        else answer += "M";
        if(mbti[3]<=0) answer += "A";
        else answer += "N";
        return answer;
    }
}