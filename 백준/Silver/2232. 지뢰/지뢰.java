import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] p = new int[n + 2]; // 양 끝 처리를 위해 크기를 n+2로 설정

        for (int i = 1; i <= n; i++) {
            p[i] = Integer.parseInt(br.readLine());
        }
        
        p[0] = 0;
        p[n + 1] = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (p[i] >= p[i - 1] && p[i] >= p[i + 1]) {
                sb.append(i).append("\n");
            }
        }

        System.out.print(sb.toString());
    }
}
