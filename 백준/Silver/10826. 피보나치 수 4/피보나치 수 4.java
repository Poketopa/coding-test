import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        BigInteger[] dp = new BigInteger[input + 1];
        if(input == 0){
            System.out.println("0");
            return;
        }
        if(input == 1){
            System.out.println("1");
            return;
        }
        dp[0] = new BigInteger("0");
        dp[1] = new BigInteger("1");
        for(int i=2;i<=input;i++){
            dp[i] = dp[i-1].add(dp[i-2]);
        }
        System.out.println(dp[input]);
    }
}