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

        int input = Integer.parseInt(br.readLine());
        int[][] dp = new int[input + 1][input + 1];
        for(int i=0;i<input;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<input;j++){
                dp[i + 1][j + 1] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=1;i<=input;i++){
            for(int j=1;j<=input;j++){
                dp[i][j] += (dp[i-1][j] + dp[i][j-1] - dp[i-1][j-1]) ;
            }
        }
        int max = Integer.MIN_VALUE;
        for(int length = 0;length < input;length++){
            for(int i=1;i<=input;i++){
                for(int j=1;j<=input;j++){
                    if(i + length > input || j + length > input) continue;
                    int temp = dp[i + length][j + length] - dp[i + length][j-1] - dp[i-1][j + length] + dp[i-1][j-1];
                    max = Math.max(max, temp);
                    if(max == 110){
                        System.out.println();
                    }
                }
            }
        }

        System.out.print(max);
    }
}
