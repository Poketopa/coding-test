import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(br.readLine());
        int F = Integer.parseInt(br.readLine());

        N /= 100;
        N *= 100;

        for(int i=0;i<100;i++){
            if((N + i) % F == 0){
                if(i < 10){
                    System.out.print("0" + i);
                }
                else System.out.print(i);
                return;
            }
        }
    }
}
