import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.valueOf(br.readLine());
        int[] arr = new int[input];
        int[] dp = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        Arrays.fill(dp, 1);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int[] dp2 = new int[input];
        Arrays.fill(dp2, 1);
        for(int i=dp2.length-1;i>=0;i--){
            for(int j=dp2.length-1;j>i;j--){
                if(arr[j]<arr[i]){
                    dp2[i] = Math.max(dp2[i], dp2[j] + 1);
                }
            }
        }
        int max = -1;
        for(int i=0;i<dp.length;i++){
            max = Math.max(max, dp[i] + dp2[i]-1);
        }

        System.out.println(max);


    }
}