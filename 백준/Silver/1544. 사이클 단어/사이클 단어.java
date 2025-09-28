import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {
	static boolean flag = false;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int repeat = Integer.parseInt(br.readLine());
		Set<String> set = new HashSet<>();
		int count = 0;
		for(int i=0;i<repeat;i++){
			String input = br.readLine();
			if(!set.contains(input)) { // 처음 들어온 문자열이면 경우를 모두 set에 저장
				for (int j = 0; j < input.length(); j++) {
					String temp = "";
					for (int k = j; k < j + input.length(); k++) {
						temp += input.charAt(k % input.length());
					}
					set.add(temp);
				}
				count++;
			}
		}
		System.out.print(count);
	}
}
