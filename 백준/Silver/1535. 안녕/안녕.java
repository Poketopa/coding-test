import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int[] hp = new int[input + 1];
        int[] pleasure = new int[input + 1];
        for(int i=1;i<=input;i++){
            hp[i] = Integer.parseInt(st.nextToken());
            pleasure[i] = Integer.parseInt(st2.nextToken());
        }
        int[][] dp = new int[input + 1][100];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                if(i == 0 || j == 0) continue;

                if(hp[i] <= j){
                    dp[i][j] = Math.max(
                            pleasure[i] + dp[i-1][j-hp[i]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[dp.length-1][dp[0].length-1]);
    }
}