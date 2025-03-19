
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        int[] num = new int[input];

        // 입력 받기
        for (int i = 0; i < input; i++) {
            num[i] = Integer.parseInt(br.readLine());
        }

        // 정렬
        Arrays.sort(num);

        // BufferedWriter를 사용하여 출력
        for (int i = 0; i < input; i++) {
            bw.write(num[i] + "\n");
        }

        // 출력 후 flush & close
        bw.flush();
        bw.close();
    }
}
