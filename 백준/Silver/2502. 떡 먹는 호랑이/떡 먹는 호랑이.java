import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int day = Integer.parseInt(st.nextToken());
        int dduck = Integer.parseInt(st.nextToken());

        int[] 피보나띠 = new int[day + 1];
        피보나띠[1] = 1;
        피보나띠[2] = 1;
        for(int i=3;i<=day;i++){
            피보나띠[i] = 피보나띠[i-1] + 피보나띠[i-2];
        }
        int x = 피보나띠[day-2];
        int y = 피보나띠[day-1];
        for(int i=1;i<dduck;i++){
            if((dduck - (x * i)) % y == 0){
                System.out.println(i);
                System.out.print((dduck - (x * i))/ y);
                return;
            }
        }
    }
}
