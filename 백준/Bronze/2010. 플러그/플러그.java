import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        int sum = 0;
        
        for(int i=0;i<input;i++) sum += Integer.parseInt(br.readLine());
        
        System.out.print(sum - input + 1);
    }
}
