import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        boolean[] dp = new boolean[input + 1];
        if(input == 1){
            System.out.println("CY");
            return;
        }
        if(input == 2){
            System.out.println("SK");
            return;
        }
        if(input == 3){
            System.out.println("CY");
            return;
        }


        // true 상근 승 / false 상근 패
        dp[1] = false;
        dp[2] = true;
        dp[3] = false;

        for(int i=4;i<=input;i++){
            if((!dp[i-1]||!dp[i-3])){
                dp[i] = true;
            }
        }
        if(dp[input])System.out.println("SK");
        else System.out.println("CY");
    }
}