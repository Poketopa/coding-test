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
	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int input = Integer.parseInt(br.readLine());
		int[] dp = new int[10001];
		Arrays.fill(dp, 1);
		dp[1] = 1; // 1

		for (int i = 2; i <= 10000; i++) dp[i] += dp[i-2];
		for (int i = 3; i <= 10000; i++) dp[i] += dp[i-3];

		for (int i = 0; i < input; i++) {
			int temp = Integer.parseInt(br.readLine());
			System.out.println(dp[temp]);
		}
	}
}
