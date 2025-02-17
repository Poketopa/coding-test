import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // ✅ BufferedWriter 사용

        int input = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[input];
        int[] sortArr = new int[input];

        for (int i = 0; i < input; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sortArr[i] = arr[i];
        }

        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(sortArr);

        int count = 0;
        map.put(sortArr[0], 0);
        for (int i = 1; i < sortArr.length; i++) {
            if (sortArr[i] != sortArr[i - 1]) {
                count++;
                map.put(sortArr[i], count);
            }
        }

        // ✅ 출력 최적화 (BufferedWriter 사용)
        for (int i = 0; i < arr.length; i++) {
            bw.write(map.get(arr[i]) + " ");
        }

        bw.flush(); // ✅ 한 번에 출력
        bw.close();
    }
}
