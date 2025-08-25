import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        double D = Double.parseDouble(st.nextToken()); // 대각선
        double H = Double.parseDouble(st.nextToken()); // 비율: 높이
        double W = Double.parseDouble(st.nextToken()); // 비율: 너비

        // 1) 비율 벡터의 길이 = sqrt(H^2 + W^2)
        double denom = Math.sqrt(H * H + W * W);

        // 2) 확대 배율 k = D / sqrt(H^2 + W^2)
        double k = D / denom;

        // 3) 실제 높이, 너비 = floor(H*k), floor(W*k)
        int height = (int) Math.floor(H * k);
        int width  = (int) Math.floor(W * k);

        // 출력: "height width"
        System.out.println(height + " " + width);
    }
}
