import java.io.*;
import java.util.*;

public class Main {
    static boolean[] even = new boolean[1000001];
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        
        int temp = 1;
        while(true){
            int count = 0;
            if(temp % a == 0) count++;
            if(temp % b == 0) count++;
            if(temp % c == 0) count++;
            if(temp % d == 0) count++;
            if(temp % e == 0) count++;
            if(count >= 3) {
                System.out.print(temp);
                break;
            }
            temp++;
        }
    }
}
