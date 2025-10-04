import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		StringBuilder sb = new StringBuilder();

		sb.append("       _.-;;-._\n");
		sb.append("'-..-'|   ||   |\n");
		sb.append("'-..-'|_.-;;-._|\n");
		sb.append("'-..-'|   ||   |\n");
		sb.append("'-..-'|_.-''-._|");

		System.out.print(sb.toString());
	}
}

