import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long game = Integer.parseInt(st.nextToken());
        long win = Integer.parseInt(st.nextToken());
        long rate = (win * 100) / game;

        if(rate >= 99){
            System.out.println("-1");
            return;
        }

        long left = 1;
        long right = 1000000000;

        while(left <= right){
            long mid = (left + right) / 2;

            long temp = ((win + mid) * 100) / (game + mid);
            if(temp <= rate){
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.print(left);
    }
}