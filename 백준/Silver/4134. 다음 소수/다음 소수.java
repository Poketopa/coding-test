
import java.io.*;
import java.util.*;

public class Main {
    static int count = 0;
    static Set<Integer> set = new HashSet<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        for(int i=0;i<input;i++){
            long temp = Long.parseLong(br.readLine());
            if(temp < 2) temp = 2;
            x : while(true){
                for(long j=2;j<=(long)Math.sqrt(temp);j++){
                    if(temp % j == 0) {
                        temp++;
                        continue x;
                    }
                }
                System.out.println(temp);
                break;
            }
        }
    }
}