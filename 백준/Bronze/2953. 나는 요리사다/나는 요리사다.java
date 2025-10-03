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

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int[] number = new int[6];
		for(int i=0;i<5;i++){
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0;j<4;j++){
				number[i+1] += Integer.parseInt(st.nextToken());
			}
		}

		int maxIndex = -1;
		int max = -1;

		for(int i=1;i<6;i++){
			if(max < number[i]){
				max = number[i];
				maxIndex = i;
			}
		}
		System.out.print(maxIndex + " " + max);
	}
}

