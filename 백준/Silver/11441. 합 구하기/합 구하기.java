import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int[] dp = new int[input + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) {
            dp[i + 1] = Integer.parseInt(st.nextToken());
        }
        for(int i=1;i<=input;i++){
            dp[i] += dp[i-1];
        }
        int num = Integer.parseInt(br.readLine());
        for(int i=0;i<num;i++){
            StringTokenizer st1 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st1.nextToken());
            int end = Integer.parseInt(st1.nextToken());
            System.out.println(dp[end] - dp[start-1]);
        }
    }
}
