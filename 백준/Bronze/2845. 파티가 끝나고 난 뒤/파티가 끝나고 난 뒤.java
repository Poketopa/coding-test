import java.io.*;
import java.util.*;

public class Main {
    static long pleasure = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken());
        int input2 = Integer.parseInt(st.nextToken());
        
        int target = input * input2;

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        for(int i=0;i<5;i++){
            System.out.print(Integer.parseInt(st2.nextToken()) - target + " ");
        }
    }
}
