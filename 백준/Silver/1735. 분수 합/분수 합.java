
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int up1 = Integer.parseInt(st1.nextToken());
        int down1 = Integer.parseInt(st1.nextToken());
        int up2 = Integer.parseInt(st2.nextToken());
        int down2 = Integer.parseInt(st2.nextToken());

        int sum2 = down1 * down2;
        int sum1 = up1 * down2 + up2 * down1;

        x : while(true){
            for(int i=2;i<=sum2;i++){
                if(sum2 % i == 0 && sum1 % i == 0){
                    sum2 /= i;
                    sum1 /= i;
                    continue x;
                }
            }
            break;
        }
        System.out.println(sum1+" "+sum2);
    }
}