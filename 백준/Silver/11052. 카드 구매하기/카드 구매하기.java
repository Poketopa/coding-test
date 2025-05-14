import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int[] number = new int[input+1];
        int[] dp = new int[input+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=1;i<=input;i++) number[i] = Integer.parseInt(st.nextToken());
        for(int i=1;i<=input;i++){
            for(int j = 1;j<=i;j++){
                dp[i] = Math.max(dp[i-j] + number[j], dp[i]);
            }
        }
        int max = -1;
        for(int i : dp) max = Math.max(max, i);
        System.out.println(max);

    }
}
