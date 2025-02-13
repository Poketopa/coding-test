
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // 🚀 BufferedWriter 추가

        int input = Integer.parseInt(br.readLine()); // 🚀 Integer.valueOf → Integer.parseInt (성능 개선)
        int[] array = new int[21];

        for (int i = 0; i < input; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String command = st.nextToken();

            if (command.equals("all")) {
                Arrays.fill(array, 1);
                continue;
            } else if (command.equals("empty")) {
                Arrays.fill(array, 0);
                continue;
            }

            int num = Integer.parseInt(st.nextToken());

            if (command.equals("add")) {
                array[num] = 1;
            } else if (command.equals("remove")) {
                array[num] = 0;
            } else if (command.equals("check")) {
                if (array[num] == 1) bw.write("1\n"); // 🚀 BufferedWriter 사용
                else bw.write("0\n"); // 🚀 BufferedWriter 사용
            } else if (command.equals("toggle")) {
                array[num] = (array[num] == 1) ? 0 : 1;
            }
        }

        bw.flush(); // 🚀 출력 버퍼 비우기
        bw.close(); // 🚀 BufferedWriter 닫기
    }
}
