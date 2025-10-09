import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int input = Integer.parseInt(br.readLine());

		if(input == 0)
			System.out.print("YONSEI");
		else System.out.print("Leading the Way to the Future");
	}
}

