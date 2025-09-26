import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int[] y = {1, -1, 0, 0};
	static int[] x = {0, 0, 1, -1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int repeat = Integer.parseInt(br.readLine());
		for(int i=0;i<repeat;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			int country = Integer.parseInt(st.nextToken());
			int plane = Integer.parseInt(st.nextToken());
			for(int j=0;j<plane;j++){
				StringTokenizer st2 = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st2.nextToken());
				int b = Integer.parseInt(st2.nextToken());
			}
			System.out.println(country - 1);
		}
	}
}
