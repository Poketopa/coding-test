import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int sum = Integer.parseInt(br.readLine());
        
        for(int i=0;i<9;i++){
            int temp = Integer.parseInt(br.readLine());
            sum -= temp;
        }
        
        System.out.print(sum);
    }
}
