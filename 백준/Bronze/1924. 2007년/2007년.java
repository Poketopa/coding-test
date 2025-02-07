import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int targetMonth = Integer.valueOf(st.nextToken());
        int targetDate = Integer.valueOf(st.nextToken());

        int month = 1;
        int date = 1;

        int count = 0;
        while(true){
            if(month == targetMonth && date == targetDate){
                if(count%7 == 0){
                    System.out.println("MON");
                    return;
                }
                else if(count%7 == 1){
                    System.out.println("TUE");
                    return;
                }
                else if(count%7 == 2){
                    System.out.println("WED");
                    return;
                }
                else if(count%7 == 3){
                    System.out.println("THU");
                    return;
                }
                else if(count%7 == 4){
                    System.out.println("FRI");
                    return;
                }
                else if(count%7 == 5){
                    System.out.println("SAT");
                    return;
                }
                else if(count%7 == 6){
                    System.out.println("SUN");
                    return;
                }
            }
            count++;
            date++;
            if(month == 1 && date == 32){
                month++;
                date = 1;
            }
            if(month == 2 && date == 29){
                month++;
                date = 1;
            }
            if(month == 3 && date == 32){
                month++;
                date = 1;
            }
            if(month == 4 && date == 31){
                month++;
                date = 1;
            }
            if(month == 5 && date == 32){
                month++;
                date = 1;
            }
            if(month == 6 && date == 31){
                month++;
                date = 1;
            }
            if(month == 7 && date == 32){
                month++;
                date = 1;
            }
            if(month == 8 && date == 32){
                month++;
                date = 1;
            }
            if(month == 9 && date == 31){
                month++;
                date = 1;
            }
            if(month == 10 && date == 32){
                month++;
                date = 1;
            }
            if(month == 11 && date == 31){
                month++;
                date = 1;
            }
        }
    }
}