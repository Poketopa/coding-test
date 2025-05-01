import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        int target = input - 2;

        long[]dp = new long[target + 1]; // 모든 숫자의 개수
        long[]zero = new long[target + 1]; // 0의 개수
        // N = 1일 때, 1개
        // N = 2일 때, 1개
        if(input == 1){
            System.out.println("1");
            return;
        }
        if(input == 2){
            System.out.println("1");
            return;
        }


        // 0이거나, 1이거나
        zero[1] = 1;
        dp[1] = 2;

        for(int i=2;i<=target;i++){
            zero[i] = dp[i-1];
            dp[i] = zero[i] + zero[i-1];
        }
        System.out.print(dp[target]);

    }
}
