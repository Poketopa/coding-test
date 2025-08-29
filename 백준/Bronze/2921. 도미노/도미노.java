import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        
        long sum = 0;
        
        for(int i=0;i<=input;i++){
            for(int j=i;j<=input;j++){
                sum += (i + j);
            }
        }
        System.out.println(sum);
    }
}
