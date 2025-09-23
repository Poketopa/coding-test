import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());

		int repeat = Integer.parseInt(br.readLine());
		for(int i=0;i<repeat;i++){
			String[] input = br.readLine().split(" ");
			while(true){
				String temp = br.readLine();
				if(temp.equals("what does the fox say?")) break;
				String[] arr = temp.split(" ");
				for(int j=0;j<input.length;j++){
					if(input[j].equals(arr[2])){
						input[j] = "";
					}
				}
			}
			for(String j : input){
				if(j.equals("")) continue;
				System.out.print(j + " ");
			}
			System.out.println("");
		}
	}
}
