import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int targetTime = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());
        int max = Integer.parseInt(st.nextToken());
        int increase = Integer.parseInt(st.nextToken());
        int rest = Integer.parseInt(st.nextToken());

        if(start + increase > max){
            System.out.print("-1");
            return;
        }


        int count = 0;
        int time = 0;
        int now = start;
        while(count < targetTime){
            time++;
            if(now + increase <= max){
                now += increase;
                count++;
                continue;
            }
            now -= rest;
            if(now < start){
                now = start;
            }
        }
        System.out.print(time);

    }
}
