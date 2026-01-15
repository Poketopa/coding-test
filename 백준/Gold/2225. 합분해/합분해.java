import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
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
        BufferedReader  br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        long[][] dp = new long[target + 1][length + 1];
        // [숫자][몇개로이루어진]

        for(int i=1;i<=target;i++){
            dp[i][1] = 1;
        }

        for(int i=2;i<=length;i++){
            for(int j=0;j<=target;j++){
                if(j==0) {
                    dp[j][i] = 1;
                    continue;
                }
                dp[j][i] += (dp[j-1][i] + dp[j][i-1]) % 1000000000;
            }
        }

        System.out.print(dp[target][length]);
    }
}
