import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int tableNum = Integer.parseInt(st.nextToken());
        int count = Integer.parseInt(st.nextToken());
        int sum = 0;
        int[][] table = new int[tableNum][tableNum];

        // 테이블 누적합 계산
        for (int i = 0; i < tableNum; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < tableNum; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (j == 0) {
                    table[i][j] = num;
                } else {
                    table[i][j] = num + table[i][j - 1];
                }
            }
        }

        // 범위 합 계산
        for (int i = 0; i < count; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken()) - 1;
            int y1 = Integer.parseInt(st.nextToken()) - 1;
            int x2 = Integer.parseInt(st.nextToken()) - 1;
            int y2 = Integer.parseInt(st.nextToken()) - 1;
            
            if (y1 == 0) {
                for (int j = x1; j <= x2; j++) {
                    sum += table[j][y2];
                }
            } else {
                for (int j = x1; j <= x2; j++) {
                    sum += (table[j][y2] - table[j][y1 - 1]);
                }
            }

            System.out.println(sum);
            sum = 0; // 다음 구간 합 계산을 위해 sum 초기화
        }
    }
}
