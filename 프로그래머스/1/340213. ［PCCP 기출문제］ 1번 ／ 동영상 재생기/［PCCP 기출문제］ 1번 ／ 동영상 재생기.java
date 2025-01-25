class Solution {
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // pos : 시작지점
        int video_length = changeTime(video_len);
        int now = changeTime(pos);
        int openingStart = changeTime(op_start);
        int openingEnd = changeTime(op_end);

        for(int i=0;i<commands.length;i++){
            if(openingStart <= now && now <= openingEnd){
                now = openingEnd;
            }
            if(commands[i].equals("next")){
                now += 10;
                if(now > video_length) now = video_length;
            }
            else if(commands[i].equals("prev")) {
                now -= 10;
                if(now < 0) now = 0;
            }
        }
        if(openingStart <= now && now <= openingEnd) {
            now = openingEnd;
        }

        String hour = String.valueOf(now / 60);
        String minute = String.valueOf(now % 60);
        if(hour.length() == 1) hour = "0" + hour;
        if(minute.length() == 1) minute = "0" + minute;
        return hour + ":" + minute;
    }

    private int changeTime(String time){
        String[] temp = time.split(":");
        int hour = Integer.valueOf(temp[0]);
        int minute = Integer.valueOf(temp[1]);
        return (hour * 60) + minute;
    }
}