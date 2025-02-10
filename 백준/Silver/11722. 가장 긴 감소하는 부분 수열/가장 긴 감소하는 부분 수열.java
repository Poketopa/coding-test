
import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.valueOf(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[input];
        for(int i=0;i<input;i++) arr[i] = Integer.valueOf(st.nextToken());
        int[] dp = new int[input];
        // n이 n-1보다 작으면 dp[i]+1
        Arrays.fill(dp, 1);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(arr[i]<arr[j]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        int max = -1;
        for(int i : dp) if(i>max) max = i;
        System.out.println(max);
    }
}