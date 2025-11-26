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

            // 0층은 1~n 고정
            // 0호는 0으로 초기화하여 점화식
            // 1부터 시작하면 인덱스에러
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
