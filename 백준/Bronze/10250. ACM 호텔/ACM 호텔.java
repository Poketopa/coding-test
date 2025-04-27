import java.io.*;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.time.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int repeat = Integer.parseInt(br.readLine());
        for(int q=0;q<repeat;q++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 세로 H 가로 W 몇 번쩨 N
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());
            int floor = ((N - 1) % H) + 1;
            int ho = ((N -1) / H) + 1;
            System.out.println((floor * 100) + ho);
        }

    }
}