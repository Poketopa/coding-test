import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int limit = Integer.parseInt(st.nextToken());
        int[] weight = new int[input + 1];
        int[] value = new int[input + 1];
        for(int i=1;i<=input;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            weight[i] = Integer.parseInt(st2.nextToken());
            value[i] = Integer.parseInt(st2.nextToken());
        }
        int[][] dp = new int[input + 1][limit + 1];
        // 세로는 물건의 개수, 가로는 최대 무게
        // 세로 -> 몇 번 물건까지 고려할 것인가
        // 가로 -> 무게를 몇까지 고려할 것인가

        int max = -1;

        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i==0 || j==0){ // 만약 넣을 수 있는 물건이 없거나 무게가 0kg일 때
                    continue;
                }
                if(weight[i] <= j){
                    if(j-weight[i]<0){
                        dp[i][j] = Math.max(dp[i-1][j],
                                value[i] + dp[i-1][0]);
                    } else{
                        dp[i][j] = Math.max(dp[i-1][j],
                                value[i] + dp[i-1][j-weight[i]]);
                    }
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
                max = Math.max(dp[i][j], max);
            }
        }
        System.out.println(max);
    }
}