

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int input = Integer.parseInt(br.readLine());
        Map<Integer, Integer> map = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < input; i++) {
            map.put(Integer.parseInt(st.nextToken()), 1);
        }

        int input2 = Integer.parseInt(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < input2; i++) {
            if (map.containsKey(Integer.parseInt(st2.nextToken()))) {
                bw.write("1 ");
            } else {
                bw.write("0 ");
            }
        }

        bw.flush(); // 버퍼 비우기 (출력 실행)
        bw.close(); // BufferedWriter 닫기
        br.close(); // BufferedReader 닫기
    }
}
