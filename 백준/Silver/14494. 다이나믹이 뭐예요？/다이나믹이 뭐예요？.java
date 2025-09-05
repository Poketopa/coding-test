import java.io.*;
import java.util.*;

public class Main {
    static long count = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int row = Integer.parseInt(st.nextToken());
        int column = Integer.parseInt(st.nextToken());

        long[][] dp = new long[row][column];
        for(int i=0;i<row;i++) dp[i][0] = 1;
        for(int i=0;i<column;i++) dp[0][i] = 1;

        for(int i=1;i<row;i++){
            for(int j=1;j<column;j++){
                dp[i][j] = (dp[i-1][j] + dp[i-1][j-1] + dp[i][j-1]);
                dp[i][j] %= 1000000007;
            }
        }

        System.out.print(dp[row-1][column-1]);
    }
}
