import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean[] isPrime = new boolean[1000001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int input = Integer.parseInt(br.readLine());
        for(int repeat = 0;repeat<input;repeat++){
            long bob = Integer.parseInt(br.readLine());
            long nowBob = bob;
            long[] today = new long[6];
            long[] tomorrow = new long[6];
            int dayCount = 1;
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<6;i++) {
                today[i] = Long.parseLong(st.nextToken());
            }
            while(true){
                for(int i=0;i<6;i++) nowBob -= today[i];
                if(nowBob < 0) break;
                for(int i=0;i<6;i++){
                    tomorrow[i] = today[(6 + i - 1) % 6] + today[(6 + i + 1) % 6] + today[(i + 3) % 6] + today[i];
                }
                for(int i=0;i<6;i++) today[i] = tomorrow[i];
                dayCount++;
                nowBob = bob;
            }
            System.out.println(dayCount);
        }
    }
}
