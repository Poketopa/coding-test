import java.util.*;

class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        int videoLength = timeTransfer(video_len);
        int now = timeTransfer(pos);
        int openingStart = timeTransfer(op_start);
        int openingEnd = timeTransfer(op_end);

        for(int i=0;i<commands.length;i++){
            if(openingStart<=now && now<=openingEnd){
                now = openingEnd;
            }
            if(commands[i].equals("prev")){
                now -= 10;
                if(now<0) now = 0;
            }
            else if(commands[i].equals("next")){
                now+=10;
                if(now>videoLength) now = videoLength;
            }
            if(openingStart<=now && now<=openingEnd){
                now = openingEnd;
            }
        }
        int hour = now / 60;
        int minute = now % 60;
        String answer = "";

        if(hour / 10 == 0){
            answer+="0";
            answer += String.valueOf(hour);
        }
        else{
            answer += String.valueOf(hour);
        }
        answer += ":";
        if(minute / 10 == 0){
            answer+="0";
            answer += String.valueOf(minute);
        }
        else{
            answer += String.valueOf(minute);
        }

        return answer;
    }

    private int timeTransfer(String input){
        String[] temp = input.split(":");
        int time = 0;
        time += Integer.valueOf(temp[0]) * 60;
        time += Integer.valueOf(temp[1]);
        return time;
    }
}