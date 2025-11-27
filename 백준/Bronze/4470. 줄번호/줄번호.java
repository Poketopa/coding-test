import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            String temp = br.readLine();
            System.out.println((i + 1) + ". " + temp);
        }

//        int[] dp = new int[2001];
//        Arrays.fill(dp, 1);
//        for(int i=3;i<=2000;i++){
//            for(int j=0;j<i/2;j++){
//                if(j == i/2 && j % 2 == 0){
//                    break;
//                }
//                dp[i] += (dp[j] + dp[i-j]);
//            }
//        }
//        System.out.println();
    }
}
