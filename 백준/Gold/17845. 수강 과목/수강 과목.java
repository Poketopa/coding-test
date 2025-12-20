import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int maxTime = Integer.parseInt(st.nextToken());
        int classes = Integer.parseInt(st.nextToken());
        int[][] array = new int[classes][2];
        for(int i=0;i<classes;i++){
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st2.nextToken());
            int b = Integer.parseInt(st2.nextToken());
            array[i][0] = a;
            array[i][1] = b;
        }
        int[][] dp = new int[classes + 1][maxTime + 1];
        for(int i=1;i<=classes;i++){
            for(int j=1;j<=maxTime;j++){
                // i번째 물건까지 고려
                if(j >= array[i-1][1]){
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-array[i-1][1]] + array[i-1][0]);
                } else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        System.out.println(dp[classes][maxTime]);
    }
}
