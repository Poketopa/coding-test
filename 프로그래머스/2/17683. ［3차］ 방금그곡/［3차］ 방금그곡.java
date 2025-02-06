import java.util.*;

class Solution {
    public String solution(String m, String[] musicinfos) {
        m = melody(m);
        // 1. 시간이 재생보다 길때 -> 재생을 반복
        // 2. 시간이 재생보다 짧을 때 -> 처음부터 시간만큼
        // * 시간을 분으로 변환하여 길이만큼 뽑아내는 함수 필요
        // * 문자열을 숫자로 변경하는 작업 필요
        int max = -1;
        String answer = "";
        for(int i=0;i<musicinfos.length;i++){
            String[] music = musicinfos[i].split(",");
            String time1 = music[0];
            String time2 = music[1];
            String name = music[2];
            String melody = melody(music[3]);
            int time = time(time1, time2);
            // time이 melody보다 길 때 -> melody 반복
            if(time>melody.length()){
                StringBuilder temp = new StringBuilder(melody);
                while(time>temp.length()){
                    temp.append(melody);
                }
                melody = temp.substring(0, time);

            }
            else if(time<melody.length()){
                melody = melody.substring(0, time);
            }
            if(melody.contains(m)) {
                if(time>max){
                    max = time;
                    answer = name;
                }
            }
        }
        if(answer.equals("")) return "(None)";
        return answer;

    }

    private int time(String time1, String time2){
        String[] times1 = time1.split(":");
        String[] times2 = time2.split(":");
        int result1 = Integer.valueOf(times1[0]) * 60 + Integer.valueOf(times1[1]);
        int result2 = Integer.valueOf(times2[0]) * 60 + Integer.valueOf(times2[1]);
        return result2 - result1;
    }

    private String melody(String temp){
        temp = temp.replace("C#", "a");
        temp = temp.replace("C", "b");
        temp = temp.replace("D#", "c");
        temp = temp.replace("D", "d");
        temp = temp.replace("E", "e");
        temp = temp.replace("F#", "f");
        temp = temp.replace("F", "g");
        temp = temp.replace("G#", "h");
        temp = temp.replace("G", "i");
        temp = temp.replace("A#", "j");
        temp = temp.replace("A", "k");
        temp = temp.replace("B#", "l");
        temp = temp.replace("B", "m");
        return temp;
    }
}