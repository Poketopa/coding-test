

import java.io.*;
import java.util.*;

public class Main {
    static int count0 = 0;
    static int count1 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        int[] numbers = new int[]{0, 1, 1, 1, 2};
        for(int i=0;i<input;i++){
            int temp = Integer.valueOf(br.readLine());
            if(temp <5) {
                System.out.println(numbers[temp]);
                continue;
            }
            long[]dp = new long[temp+1];
            for(int j=0;j<=4;j++) dp[j] = numbers[j];
            for(int j=5;j<=temp;j++){
                dp[j] = dp[j-1] + dp[j-5];
            }
            System.out.println(dp[temp]);
        }

    }
}