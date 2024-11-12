class Solution {
    public String solution(int a, int b) {
        String answer = "";
        int month = 1;
        int day =1 ;
        int week = 1;
        while (true){
            if(a==month&&b==day){
                if(week%7==1){
                    answer = "FRI";
                    return answer;
                }
                if(week%7==2){
                    answer = "SAT";
                    return answer;
                }
                if(week%7==3){
                    answer = "SUN";
                    return answer;
                }
                if(week%7==4){
                    answer = "MON";
                    return answer;
                }
                if(week%7==5){
                    answer = "TUE";
                    return answer;
                }
                if(week%7==6){
                    answer = "WED";
                    return answer;
                }
                if(week%7==0){
                    answer = "THU";
                    return answer;
                }
                
            }
            day++;
            week++;
            if(month==1||month==3||month==5||month==7||month==8||month==10||month==12){
                if(day==32){
                    month++;
                    day=1;
                }
            }
            else if(month==2){
                if(day==30){
                    month++;
                    day=1;
                }
            }
            else{
                if(day==31){
                    month++;
                    day=1;
                }
            }
        }
    }
}