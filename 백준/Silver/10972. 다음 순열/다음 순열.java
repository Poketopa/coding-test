import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static boolean flag = false;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int input = Integer.parseInt(br.readLine());
		int[] number = new int[input];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0;i<input;i++) number[i] = Integer.parseInt(st.nextToken());

		int prev = -1;
		int index = input-1;
		// 뒤에서부터 확인, 역방향으로 오름차순을 확인하며 아닌 구간을 확인한다
		while(number[index] > prev){
			prev = number[index];
			index--;
			if(index == -1){
				System.out.print("-1");
				return;
			}
		}


		// 아닌 곳을 기준으로 해당 숫자보다 큰 숫자를 찾아 스왑
		List<Integer> list = new ArrayList<>();
		for(int i=index +1;i<input;i++) list.add(number[i]);
		Collections.sort(list);
		for(int i=0;i<list.size();i++){
			if(number[index] < list.get(i)){
				int temp = number[index];
				number[index] = list.get(i);
				list.set(i, temp);
				break;
			}
		}

		// 나머지 부분을 정렬
		for(int i=0;i<list.size();i++){
			number[index+1+i] = list.get(i);
		}

		for(int i=0;i<input;i++){
			System.out.print(number[i] + " ");
		}
	}
}
