import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		String str1 = br.readLine();
		String str2 = br.readLine();

		if (str1.length() < str2.length())
			System.out.print("no");
		else
			System.out.println("go");
	}
}

