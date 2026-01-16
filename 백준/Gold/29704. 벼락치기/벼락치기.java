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
        int problem = Integer.parseInt(st.nextToken());
        int time = Integer.parseInt(st.nextToken());

        int[] dp = new int[time + 1];
        int sum = 0;

        for (int i = 0; i < problem; i++) {
            st = new StringTokenizer(br.readLine());
            int days = Integer.parseInt(st.nextToken());
            int fine = Integer.parseInt(st.nextToken());

            sum += fine;

            for(int j=time;j>=days;j--){
                dp[j] = Math.max(dp[j], dp[j-days] + fine);
            }
        }
        System.out.print(sum - dp[time]);
    }
}
