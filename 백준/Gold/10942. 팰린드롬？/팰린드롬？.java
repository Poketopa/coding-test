
import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine());
        int[] number = new int[N];
        int[] oddNum = new int[N];
        int[] evenNum = new int[N - 1];

        // 숫자 입력 받기
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            number[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());

        // 홀수 길이 팰린드롬 계산
        for (int i = 0; i < N; i++) {
            int left = i;
            int right = i;
            while (0 <= left && left < N && 0 <= right && right < N && number[left] == number[right]) {
                left--;
                right++;
            }
            oddNum[i] = right - left - 1;
        }

        // 짝수 길이 팰린드롬 계산
        for (int i = 0; i < N - 1; i++) {
            int left = i;
            int right = i + 1;
            while (0 <= left && left < N && 0 <= right && right < N && number[left] == number[right]) {
                left--;
                right++;
            }
            evenNum[i] = right - left - 1;
        }

        // 질의 처리
        for (int i = 0; i < M; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st2.nextToken()) - 1;
            int end = Integer.parseInt(st2.nextToken()) - 1;
            int middle = (end + start) / 2;
            int length = end - start + 1;

            // 홀수 길이 팰린드롬 검증
            if (length % 2 == 1) {
                if (oddNum[middle] >= length) bw.write("1\n");
                else bw.write("0\n");
            }
            // 짝수 길이 팰린드롬 검증
            else {
                if (evenNum[middle] >= length) bw.write("1\n");
                else bw.write("0\n");
            }
        }

        // 출력 후 flush & close
        bw.flush();
        bw.close();
    }
}
