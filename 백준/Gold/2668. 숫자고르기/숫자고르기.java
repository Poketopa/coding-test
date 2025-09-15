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

		int input = Integer.parseInt(br.readLine());
		int[] number = new int[input + 1];
		for(int i=1;i<=input;i++) number[i] = Integer.parseInt(br.readLine());
		Set<Integer> answer = new HashSet<>();

		// 1. set을 만들어 저장하며 사이클이 발견되면 sum을 비교한다.
		// 2. 이 때 sum은 인덱스와 값 sum이 각각 존재한다
		for(int i=1;i<=input;i++){
			Set<Integer> set = new HashSet<>();
			int indexSum = 0;
			int valueSum = 0;
			int index = i;
			while(true){
				if(set.contains(number[index])){ // 사이클 발견
					if(indexSum == valueSum){ // 진짜 사이클이면 리스트에 추가
						for(int j : set) answer.add(j);
					}
					break;
				}
				set.add(number[index]);
				indexSum += index;
				valueSum += number[index];
				index = number[index];
			}
		}
		List<Integer> temp = new ArrayList<>(answer);
		Collections.sort(temp);
		System.out.println(temp.size());
		for(int i : temp)System.out.println(i);
	}
}
