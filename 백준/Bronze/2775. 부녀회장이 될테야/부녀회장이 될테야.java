import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int testCast = Integer.parseInt(br.readLine());
        for(int repeat = 0;repeat < testCast;repeat++){
            int floor = Integer.parseInt(br.readLine());
            int ho = Integer.parseInt(br.readLine());

            int[][] apart = new int[floor + 1][ho + 1];
            for(int i=1;i<=ho;i++) apart[0][i] = i;

            for(int i=1;i<=floor;i++){
                for(int j=1;j<=ho;j++){
                    apart[i][j] = apart[i-1][j] + apart[i][j-1];
                }
            }
            System.out.println(apart[floor][ho]);
        }
    }
}
