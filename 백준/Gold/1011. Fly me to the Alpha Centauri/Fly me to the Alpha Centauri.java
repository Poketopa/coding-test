import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());


		int input = Integer.parseInt(br.readLine());
		for(int i=0;i<input;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int number = b - a;

			long count = 0;
			long sum = 0;
			long temp = 1;

			for(int j=0;j<Integer.MAX_VALUE;j++){
				count++; // 숫자가 몇개인지?
				sum += temp;
				if(sum >= number){
					System.out.println(count--);
					break;
				}

				count++;
				sum += temp;
				if(sum >= number){
					System.out.println(count--);
					break;
				}

				temp++; // 몇개씩 넘어갈건지
			}
		}

		// 3일 때 -> 3
		// 4일 때 -> 3
		// 5일 때 -> 4

		// 홀수 -> 가운데 1개
		// 짝수 -> 2개

		// 1 2 3 3 4 4 5 5 5 6 6 6

		// 1
		// 1 1
		// 1 1 1
		// 1 2 1
		// 1 2 1 1
		// 1 2 2 1
		// 1 2 1 2 1
		// 1 2 2 2 1
		// 1 2 3 2 1
		// 1 2 3 2 1 1 -> 10
		// 1 2 3 2 2 1
		// 1 2 3 3 2 1
	}
}






