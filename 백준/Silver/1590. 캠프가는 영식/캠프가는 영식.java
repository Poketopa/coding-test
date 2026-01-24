import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int bus = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        int[][]info = new int[bus][3];

        for(int i=0;i<bus;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st2.nextToken());
            info[i][1] = Integer.parseInt(st2.nextToken());
            info[i][2] = Integer.parseInt(st2.nextToken());
        }

        int min = Integer.MAX_VALUE;

        for(int i=0;i<bus;i++){
            int time = info [i][0];
            for(int j=0;j<info[i][2];j++){
                if(time >= arrive){
                    min = Math.min(min, time - arrive);
                    break;
                }
                time += info[i][1];
            }
        }

        if(min == Integer.MAX_VALUE){
            System.out.print("-1");
        } else{
            System.out.print(min);
        }


    }
}
