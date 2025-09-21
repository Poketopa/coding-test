import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int input = Integer.parseInt(br.readLine());

		for(int i=0;i<input-1;i++){
			for(int j=0;j<input-i-1;j++) System.out.print(" ");
			System.out.print("*");
			for(int j=0;j<(i * 2) -1;j++) System.out.print(" ");
			if(i != 0)System.out.print("*");
			System.out.println("");
		}
		for(int i=0;i<(2*input) -1;i++){
			System.out.print("*");
		}
	}
}
