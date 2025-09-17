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

		StringTokenizer st = new StringTokenizer(br.readLine());
		int row = Integer.parseInt(st.nextToken());
		int length = Integer.parseInt(st.nextToken());
		int count = 0;

		int[][] map = new int[row][row];
		int[][] visited = new int[row][row];
		for(int i=0;i<row;i++){
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j=0;j<row;j++){
				map[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		// 가로 먼저
		x:for(int i=0;i<row;i++){
			for(int j=0;j<row-1;j++){
				if(map[i][j] != map[i][j + 1]){ // 다르면 낮은 곳 찾기
					if(Math.abs(map[i][j] - map[i][j+1]) > 1) continue x;
					if(map[i][j] < map[i][j + 1]){ // 왼쪽이 낮을 때는 왼쪽 체크
						int temp = j;
						for(int k=0;k<length;k++){
							if(temp < 0 || map[i][temp] != map[i][j] || visited[i][temp] == 1){
								continue x;
							}
							temp--;
						}
						for(int k=0;k<length;k++){
							visited[i][j - k] = 1;
						}
					} else if(map[i][j] > map[i][j + 1]){ // 오른쪽 체크
						int temp = j + 1;
						for(int k=0;k<length;k++){
							if(temp >= row || map[i][temp] != map[i][j + 1] || visited[i][temp] == 1){
								continue x;
							}
							temp++;
						}
						for(int k=0;k<length;k++){
							visited[i][j + 1 + k] = 1;
						}
					}
				}
			}
			count++;

		}

		for(int i=0;i<row;i++){
			for(int j=0;j<row;j++){
				visited[i][j] = 0;
			}
		}

		x:for(int i=0;i<row;i++){
			for(int j=0;j<row-1;j++){
				if(map[j][i] != map[j + 1][i]){ // 다르면 낮은 곳 찾기
					if(Math.abs(map[j][i] - map[j + 1][i]) > 1) continue x;
					if(map[j][i] < map[j + 1][i]){ // 위쪽이 낮을 때는 위쪽 체크
						int temp = j;
						for(int k=0;k<length;k++){
							if(temp < 0 || map[temp][i] != map[j][i] || visited[temp][i] == 1){
								continue x;
							}
							temp--;
						}
						for(int k=0;k<length;k++){
							visited[j - k][i] = 1;
						}
					} else if(map[j][i] > map[j + 1][i]){ // 오른쪽 체크
						int temp = j + 1;
						for(int k=0;k<length;k++){
							if(temp >= row || map[temp][i] != map[j + 1][i] || visited[temp][i] == 1){
								continue x;
							}
							temp++;
						}
						for(int k=0;k<length;k++){
							visited[j + 1 + k][i] = 1;
						}
					}
				}
			}
			count++;

		}
		System.out.print(count);
	}
}
