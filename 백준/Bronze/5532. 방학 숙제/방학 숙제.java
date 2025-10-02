import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
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

		int L = Integer.parseInt(br.readLine()); // 방학 일수
		int A = Integer.parseInt(br.readLine()); // 국어 숙제
		int B = Integer.parseInt(br.readLine()); // 수학 숙제
		int C = Integer.parseInt(br.readLine()); // 국어 최대
		int D = Integer.parseInt(br.readLine()); // 수학 최대

		double a = (double)A / (double)C;
		double b = (double)B / (double)D;

		double max = Math.max(a, b);

		if(max % 1 == 0){
			System.out.print(L - (int)max);
		}
		else{
			System.out.print(L - (int)max -1);
		}
	}
}

