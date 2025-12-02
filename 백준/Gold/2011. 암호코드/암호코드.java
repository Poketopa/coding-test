import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        String input = br.readLine();
        for(int i=0;i<input.length();i++){
            if(!('0' <= input.charAt(i) && input.charAt(i) <= '9')){
                System.out.print("0");
                return;
            }
        }

        int[] dp = new int[input.length()+1];

        dp[0] = 1;
        for(int i=1;i<=input.length();i++){
            if(i > 1 && input.charAt(i-2) != '0'){
                int temp = 0;
                temp += 10 * (input.charAt(i-2) - '0');
                temp += input.charAt(i-1) - '0';
                if(1 <= temp && temp <= 26){
                    dp[i] += dp[i-2];
                }
            }
            if(input.charAt(i-1) != '0') dp[i] += dp[i-1];
            dp[i] %= 1000000;
        }
        System.out.println(dp[dp.length-1]);
    }
}
