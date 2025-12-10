import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());

        int[] dp = new int[input + 1];
        // n번째에 누가 가져가는가?
        // 1 = 상근, 2 = 창영


        // 만약? 상근이 이기는 경우
        // -> dp[i-1], dp[i-3], dp[i-4]가 상근일 때

        for(int i=1;i<=input;i++){
            int temp = i % 7;
            if(temp == 1 || temp == 3) dp[i] = 2;
            else dp[i] = 1;
        }

        if(dp[input] == 1) System.out.print("SK");
        else System.out.print("CY");

        // 1개 -> 창영 승
        // 2개 -> 상근 승
        // 3개 -> 창영 승
        // 4개 -> 상근 승
        // 5개 -> 상근 승
        // 6개 -> 상근 승
        // 7개 -> 상근 승
    }
}
