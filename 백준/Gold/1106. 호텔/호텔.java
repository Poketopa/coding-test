import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int target = Integer.parseInt(st.nextToken());
        int city = Integer.parseInt(st.nextToken());

        int[][] arr = new int[city][2];
        double max = Double.MIN_VALUE;
        int maxIndex = 0;
        for(int i=0;i<city;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st2.nextToken());
            arr[i][1] = Integer.parseInt(st2.nextToken());
        }

        int[] dp = new int[1000000];

        for(int i=1;i<dp.length;i++){
            for(int j=0;j<city;j++){
                if(i - arr[j][0] < 0) continue;
                if(dp[i] < dp[i-arr[j][0]] + arr[j][1]){
                    dp[i] = dp[i-arr[j][0]] + arr[j][1];
                    if(dp[i] >= target){
                        System.out.print(i);
                        return;
                    }
                }
            }
            }
    }
}
