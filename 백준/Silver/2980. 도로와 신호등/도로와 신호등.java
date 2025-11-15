import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());
        int[][] light = new int[input][3];
        for(int i=0;i<input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            light[i][0] = Integer.parseInt(st2.nextToken());
            light[i][1] = Integer.parseInt(st2.nextToken());
            light[i][2] = Integer.parseInt(st2.nextToken());
        }
        int index = 0;
        int time = 0;
        int now = 0;
        while(true){
            // 신호등 도착 안했으면 시간, 위치 +1
            if(index == input ||now < light[index][0]){
                now++;
            }
            else{
                if((time % (light[index][1] + light[index][2])) >= light[index][1]){
                    index++;
                    now++;
                }
            }
            time++;
            if(now == length){
                System.out.print(time);
                return;
            }
        }
    }
}
