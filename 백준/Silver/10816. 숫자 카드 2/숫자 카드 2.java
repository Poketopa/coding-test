
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 🚀 BufferedWriter 추가

        HashMap<Integer, Integer> map = new HashMap<>();
        int input1 = Integer.parseInt(br.readLine()); // 🚀 Integer.valueOf → Integer.parseInt (성능 개선)
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < input1; i++) {
            int temp = Integer.parseInt(st.nextToken());
            map.put(temp, map.getOrDefault(temp, 0) + 1);
        }

        int input2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());

        for (int i = 0; i < input2; i++) {
            int temp = Integer.parseInt(st2.nextToken());
            bw.write(map.getOrDefault(temp, 0) + " "); // 🚀 BufferedWriter로 변경
        }

        bw.flush(); // 🚀 출력 버퍼 비우기
        bw.close(); // 🚀 BufferedWriter 닫기
    }
}
