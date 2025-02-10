import java.io.*;
import java.util.*;

public class Main{
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.valueOf(br.readLine());
        int[] arr = new int[input];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<arr.length;i++){
            arr[i] = Integer.valueOf(st.nextToken());
        }
        int[] dp = new int[input];
        int max = -1;
        Arrays.fill(dp, 1);
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<i;j++){
                if(arr[j]<arr[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }
        for(int i : dp) if(max<i) max = i;
        System.out.println(max);


    }
}