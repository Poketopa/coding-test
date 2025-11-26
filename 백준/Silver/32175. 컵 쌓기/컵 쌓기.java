import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int cup = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[] cups = new int[cup];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i=0;i<cup;i++) cups[i] = Integer.parseInt(st2.nextToken());
        long[] dp = new long[height + 1];

        dp[0] = 1;
        for(int i=1;i<=height;i++){
            for(int j=0;j<cup;j++){
                if(i - cups[j] < 0) continue;
                dp[i] += dp[i - cups[j]];
                dp[i] %= 1000000007;
            }
        }
        System.out.print(dp[height]);
    }
}
