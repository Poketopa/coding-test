
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line;
        while ((line = br.readLine()) != null) {
            line = line.trim();
            if (line.equals("")) continue; // 공백 줄 무시
            int input = Integer.parseInt(line);
            int[] number = new int[input];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < input; i++) {
                number[i] = Integer.parseInt(st.nextToken());
            }

            List<Integer> list = new ArrayList<>();
            int index = 0;
            while (index < input) {
                if (list.isEmpty() || list.get(list.size() - 1) < number[index]) {
                    list.add(number[index]);
                } else {
                    binarySearch(list, number[index], 0, list.size() - 1);
                }
                index++;
            }

            bw.write(list.size() + "\n");
        }

        bw.flush();
        bw.close();
    }

    private static void binarySearch(List<Integer> list, int num, int start, int end) {
        while (start <= end) {
            int mid = (start + end) / 2;
            if (list.get(mid) >= num) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        // 이 부분은 원래 로직과 완전히 동일하게 유지합니다
        list.set(start, num);
    }
}
