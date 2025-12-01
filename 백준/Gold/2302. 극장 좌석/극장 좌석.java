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
        Set<Integer> set = new HashSet<>();
        int vip = Integer.parseInt(br.readLine());
        for(int i=0;i<vip;i++) set.add(Integer.parseInt(br.readLine()));

        int[][]dp = new int[input + 1][2];
        dp[1][0] = 1;
        // 0 움직이지 않음
        // 1 앞자리와 교체

        for(int i=2;i<=input;i++){
            if(set.contains(i) || set.contains(i-1)){
                dp[i][0] = dp[i-1][0] + dp[i-1][1];
                continue;
            }
            dp[i][0] += (dp[i-1][0] + dp[i-1][1]);
            dp[i][1] += dp[i-1][0];
        }
        System.out.print(dp[input][0] + dp[input][1]);
    }
}
