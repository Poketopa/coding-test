import java.io.*;
import java.util.*;

public class Main {
    static int pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 현재까지 가장 작은 것
        // 현재까지 가장 큰 것
        int[] small = new int[input + 1];
        int[] big = new int[input + 1];
        int[]dp = new int[input];
        for(int i=0;i<input;i++) dp[i] = Integer.parseInt(st.nextToken());
        Arrays.fill(small, Integer.MAX_VALUE);
        Arrays.fill(big,Integer.MIN_VALUE);
        int max = Integer.MIN_VALUE;

        for(int i=0;i<input;i++){
            small[i+ 1] = Math.min(small[i], dp[i]);
            big[i + 1] = Math.max(big[i], dp[i]);

            if(small[i + 1] != small[i]){
                big[i+1] = small[i+1];
            }
            
            max = Math.max(max, big[i+1] - small[i + 1]);


            System.out.print(max + " ");
        }
    }
}
