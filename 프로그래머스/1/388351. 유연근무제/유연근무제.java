import java.util.*;
class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0;i<schedules.length;i++){
            int time = changeTime(schedules[i]);
            int count = 0;
            int day = startday;
            for(int j=0;j<timelogs[i].length;j++){
                if(day == 6 || day == 7) {
                    day++;
                if(day>7) day %= 7;
                    continue;
                }
                if(timelogs[i][j]<=time){
                    System.out.println("데드라인 : " +time + "도착시간 : " + timelogs[i][j]);
                    count++;
                }
                day++;
                if(day>7) day %= 7;
            }
            if(count == 5) answer++;
            
            
        }
        return answer;
    }
    
    private int changeTime(int time){
        int minute = time % 100;
        int hour = time / 100;
        minute += 10;
        if(minute > 59){
            minute %= 60;
            hour++;
        }
        return (hour * 100) + minute;
    }
}