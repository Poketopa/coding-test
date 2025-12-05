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

        int[] number = new int[input + 1];
        int[] dp = new int[input + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<input;i++) number[i + 1] = Integer.parseInt(st.nextToken());

        dp[0] = 0;
        dp[1] = 0;
        for(int i=1;i<=input;i++){
            for(int j=i;j>=1;j--){
                int score = getScore(number, j, i);
                dp[i] = Math.max(dp[i], (score + dp[j-1]));
            }
        }
        System.out.print(dp[input]);
    }

    public static int getScore(int[] number, int start, int end){
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i=start;i<=end;i++){
            max = Math.max(max, number[i]);
            min = Math.min(min, number[i]);
        }
        return max - min;
    }
}
