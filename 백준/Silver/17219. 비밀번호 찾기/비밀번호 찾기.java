
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 🚀 BufferedWriter 추가

        StringTokenizer st = new StringTokenizer(br.readLine());
        int input1 = Integer.parseInt(st.nextToken()); // 🚀 Integer.valueOf → Integer.parseInt (성능 개선)
        int input2 = Integer.parseInt(st.nextToken());

        HashMap<String, String> map = new HashMap<>();

        for (int i = 0; i < input1; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            String site = st2.nextToken();
            String pw = st2.nextToken();
            map.put(site, pw);
        }

        for (int i = 0; i < input2; i++) {
            String temp = br.readLine();
            bw.write(map.get(temp) + "\n"); // 🚀 BufferedWriter 사용
        }

        br.close(); // 🚀 BufferedReader 닫기
        bw.flush(); // 🚀 출력 버퍼 비우기
        bw.close(); // 🚀 BufferedWriter 닫기
    }
}
