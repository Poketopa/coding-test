import java.io.*;
import java.util.*;

public class Main {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out)); // BufferedWriter 선언

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine()); // 입력값 변환
        br.close(); // 더 이상 입력이 필요 없으므로 닫기

        int sum = 1;
        int count = 1;
        for (int i = 2; i <= input; i++) {
            count *= 2;
            sum += count;
        }

        bw.write(sum + "\n"); // 총 이동 횟수 출력
        hanoi(input, 1, 2, 3); // 하노이 함수 호출

        bw.flush(); // 출력 버퍼 비우기
        bw.close(); // BufferedWriter 닫기
    }

    private static void hanoi(int number, int from, int sub, int to) throws IOException {
        if (number < 1) return;

        hanoi(number - 1, from, to, sub);
        bw.write(from + " " + to + "\n"); // 이동 출력
        hanoi(number - 1, sub, from, to);
    }
}
