import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int[] y = {1, -1, 0, 0};
	static int[] x = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int column = Integer.parseInt(st.nextToken());
		int[][] map = new int[row][column];
		for(int i=0;i<row;i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<column;j++){
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		int[][] dp = new int[row][column];
		for(int i=0;i<row;i++) Arrays.fill(dp[i], -1);

		System.out.print(dfs(map, 0, 0, dp));
	}
	public static int dfs(int[][] map, int nowY, int nowX, int[][] dp){
		// 도착하면 백
		if(nowY == map.length-1 && nowX == map[0].length-1){
			return 1;
		}
		if(dp[nowY][nowX] != -1){
			return dp[nowY][nowX];
		}

		dp[nowY][nowX] = 0;

		for(int i=0;i<4;i++){
			int newY = nowY + y[i];
			int newX = nowX + x[i];
			if(0 <= newY && newY < map.length
			&& 0 <= newX && newX < map[0].length
			&& map[nowY][nowX] > map[newY][newX]){
				dp[nowY][nowX] += dfs(map, newY, newX, dp);
			}
		}

		return dp[nowY][nowX];
	}
}
