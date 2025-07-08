import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        long[][] dp = new long[31][31];
        dp[0][0] = 1;
        for(int i=1;i<=30;i++){
            for(int j=0;j<i;j++){
                if(j == 0) dp[i][j] = 1;
                else dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
            }
        }
        long sum = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int temp = C;
        for(int i=R;i<R + W;i++){

            for(int j=C-1;j<temp;j++){
                sum += dp[i][j];
            }
            temp++;
        }
        System.out.println(sum);
    }
}