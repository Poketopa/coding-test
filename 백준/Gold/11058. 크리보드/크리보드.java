import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        if(input <= 3){
            System.out.print(input);
            return;
        }

        long[][]dp = new long[input + 1][2];
        for(int i=1;i<=4;i++) dp[i][0] = i;

        for(int i=5;i<=input;i++){
            long copy = dp[i-1][1];
            // 복붙 3번까지
            long one = dp[i-3][0] * 2;
            long two = dp[i-4][0] * 3;
            long three = dp[i-5][0] * 4;

            if(copy != 0 && copy > one && copy > two && copy > three){
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                dp[i][1] = dp[i-1][1];
            }
            else if(dp[i-1][0] + 1 > one && dp[i-1][0] + 1 > two && dp[i-1][0] + 1 > three){
                dp[i][0] = dp[i-1][0] + 1;
                dp[i][1] = dp[i-1][1];
            }
            else if(one >= two && one >= three){
                dp[i][0] = one;
                dp[i][1] = dp[i-3][0];
            }
            else if(two >= one && two >= three){
                dp[i][0] = two;
                dp[i][1] = dp[i-4][0];
            }
            else if(three >= one && three >= two){
                dp[i][0] = three;
                dp[i][1] = dp[i-5][0];
            }
        }

        System.out.print(dp[input][0]);
    }
}
