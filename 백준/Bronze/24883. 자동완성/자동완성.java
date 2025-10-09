import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		String input = br.readLine();
		
		if(input.equals("N") || input.equals("n"))
			System.out.print("Naver D2");
		else 
			System.out.print("Naver Whale");
	}
}

