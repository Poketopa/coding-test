import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static int min = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		Integer[] coin = new Integer[N];
		for(int i=0;i<N;i++) coin[i] = Integer.parseInt(br.readLine());
		Arrays.sort(coin);

		int[] dp = new int[target + 1];

		for(int i=1;i<=target;i++){
			int min = Integer.MAX_VALUE;
			for(int j=0;j<N;j++){
				if(i - coin[j] >= 0 && dp[i-coin[j]] != -1){
					min = Math.min(min, dp[i-coin[j]]);
				} else{
					continue;
				}
			}
			if(min == Integer.MAX_VALUE) dp[i] = -1;
			else  dp[i] = min + 1;
		}
		System.out.print(dp[target]);
	}
}
