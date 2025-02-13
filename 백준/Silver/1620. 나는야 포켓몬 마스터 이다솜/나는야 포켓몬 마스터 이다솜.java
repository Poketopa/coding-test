
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 🚀 BufferedWriter 추가

        StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(st.nextToken()); // 🚀 Integer.valueOf → Integer.parseInt (성능 개선)
        int quiz = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> stringIntMap = new HashMap<>();
        HashMap<Integer, String> intStringMap = new HashMap<>();
        int count = 1;

        for (int i = 0; i < input; i++) {
            String temp = br.readLine();
            stringIntMap.put(temp, count);
            intStringMap.put(count, temp);
            count++;
        }

        for (int i = 0; i < quiz; i++) {
            String temp = br.readLine();
            if ('0' <= temp.charAt(0) && temp.charAt(0) <= '9') {
                bw.write(intStringMap.get(Integer.parseInt(temp)) + "\n"); // 🚀 BufferedWriter 사용
            } else {
                bw.write(stringIntMap.get(temp) + "\n"); // 🚀 BufferedWriter 사용
            }
        }

        br.close(); // 🚀 BufferedReader 닫기
        bw.flush(); // 🚀 출력 버퍼 비우기
        bw.close(); // 🚀 BufferedWriter 닫기
    }
}
