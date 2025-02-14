

import java.io.*;
import java.util.*;

public class Main {
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            int number = Integer.parseInt(br.readLine());
            int[][] card = new int[2][number];
            for(int j=0;j<2;j++){
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int k=0;k<number;k++){
                    card[j][k] = Integer.parseInt(st.nextToken());
                }
            }
            if(number == 1){
                System.out.println(Math.max(card[0][0], card[1][0]));
                continue;
            }
            else if(number == 2){
                System.out.println(Math.max(card[0][0] + card[1][1], card[0][1] + card[1][0]));
                continue;
            }
            int[][] dp = new int[2][number];
            dp[0][0] = card[0][0]; dp[1][0] = card[1][0];
            dp[0][1] = card[0][1] + card[1][0];
            dp[1][1] = card[1][1] + card[0][0];
            for(int j=2;j<number;j++){
                dp[0][j] = Math.max(card[0][j] + dp[1][j-1], card[0][j] + dp[1][j-2]);
                dp[1][j] = Math.max(card[1][j] + dp[0][j-1], card[1][j] + dp[0][j-2]);
            }
            int max = -1;
            for(int j=0;j<dp.length;j++){
                for(int k=0;k<dp[0].length;k++){
                    max = Math.max(max, dp[j][k]);
                }
            }
            System.out.println(max);
        }

    }
}