

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 🚀 BufferedWriter 추가

        StringTokenizer st = new StringTokenizer(br.readLine());
        int see = Integer.parseInt(st.nextToken()); // 🚀 Integer.valueOf → Integer.parseInt (성능 개선)
        int hear = Integer.parseInt(st.nextToken());

        HashMap<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        for (int i = 0; i < see + hear; i++) {
            String temp = br.readLine();
            map.put(temp, map.getOrDefault(temp, 0) + 1);
            if (map.get(temp) == 2) list.add(temp);
        }

        bw.write(list.size() + "\n"); // 🚀 BufferedWriter 사용

        Collections.sort(list); // 사전순 정렬

        for (String name : list) {
            bw.write(name + "\n"); // 🚀 BufferedWriter 사용
        }

        br.close(); // 🚀 BufferedReader 닫기
        bw.flush(); // 🚀 출력 버퍼 비우기
        bw.close(); // 🚀 BufferedWriter 닫기
    }
}
