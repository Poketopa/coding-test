import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input];
        for(int i=0;i<input;i++){
            number[i] = Integer.parseInt(br.readLine());
        }
        int max = -1;
        for(int i : number) max = Math.max(max, i);
        long[]dp = new long[max + 1];
        if(max>=0){
            dp[0] = 1;
        }
        if(max>=1){
            dp[1] = 1;
        }
        if(max>=2){
            dp[2] = 2;
        }
        if(max>=3){
            dp[3] = 4;
        }

        if(max >= 4){
            for(int j=4;j<=max;j++){
                dp[j] = dp[j-1] + dp[j-2] + dp[j-3] + dp[j-4];
            }
        }

        for(int i : number){
            System.out.println(dp[i]);
        }

    }
}