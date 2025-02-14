
import java.io.*;
import java.util.*;

public class Main {
    static int count0 = 0;
    static int count1 = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        for(int i=0;i<input;i++){
            count0 = 0;
            count1 = 0;
            int temp = Integer.valueOf(br.readLine());
            if(temp == 0){
                System.out.println(("1 0"));
                continue;
            }
            else if(temp == 1){
                System.out.println(("0 1"));
                continue;
            }
            else{
                int[][] dp = new int[temp+1][2];
                dp[0] = new int[]{1, 0};
                dp[1] = new int[]{0, 1};
                for(int j=2;j<=temp;j++){
                    dp[j][0] = dp[j-1][0] + dp[j-2][0];
                    dp[j][1] = dp[j-1][1] + dp[j-2][1];
                }
                System.out.println(dp[temp][0]+" "+dp[temp][1]);
            }
        }
    }
}