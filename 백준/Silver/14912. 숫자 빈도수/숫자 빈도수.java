import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int count = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		int number = Integer.parseInt(st.nextToken());
		int target = Integer.parseInt(st.nextToken());

		for(int i=1;i<=number;i++){
			int temp = i;
			while(temp > 0){
				if(temp % 10 == target) count++;
				temp /= 10;
			}
		}
		System.out.print(count);
	}
}
