import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int[] belt = new int[N*2];
		for(int i=0;i<N*2;i++) belt[i] = Integer.parseInt(st2.nextToken());
		int[] robot = new int[N];
		int count = 0;

		while(true){
			count++;
			// 1. 벨트와 로봇을 오른쪽으로 한 칸 이동
			int temp = belt[belt.length-1];
			for(int i = belt.length-1;i>0;i--)belt[i] = belt[i-1];
			belt[0] = temp;
			for(int i=robot.length-1;i>0;i--) robot[i] = robot[i-1];
			robot[0] = 0;
			robot[robot.length-1] = 0;
			// 2. 이동 가능한 로봇은 내구도 확인 후 이동
			for(int i=robot.length-1;i>0;i--){
				if(robot[i] == 0){
					// 만약 다 옮길 수 있으면
					if(belt[i] >= robot[i-1]){
						belt[i] -= robot[i-1];
						robot[i] += robot[i-1];
						robot[i-1] = 0;
					}
					// 다 옮길 수 없으면
					else if(belt[i] < robot[i-1]){
						robot[i-1] -= belt[i];
						robot[i] += belt[i];
						belt[i] = 0;
					}
				}
			}
			// 3. 올리는 위치에 로봇을 올린다.
			if(belt[0]>0) {
				robot[0]++;
				belt[0]--;
			}
			int tempCount = 0;
			for(int i : belt){
				if(i == 0) tempCount++;
			}
			if(tempCount >= K) {
				System.out.print(count);
				return;
			}
		}
	}
}
