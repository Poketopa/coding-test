import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int input  = Integer.parseInt(br.readLine());
		int[][] arr = new int[input][2];
		List<Integer> list = new ArrayList<>();
		for(int i=0;i<input;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			list.add(arr[i][1] - arr[i][0]);
		}
		if(input % 2 == 1){
			System.out.print("1");
			return;
		}
		Collections.sort(list);
		System.out.print(list.get((list.size()/2)) - list.get((list.size()/2) -1) + 1);
	}
}
