import java.io.*;
import java.util.*;

public class Main {
    static boolean flag = false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //StringTokenizer st = new StringTokenizer(br.readLine());
        int input = Integer.parseInt(br.readLine());
        if(input ==1) {
            System.out.println("1");
            return;
        }

        long[][] number = new long[2][input-1];
        number[0][0] = 1;
        number[1][0] = 1;
        // 0 -> 연결 안 할 때
        // 1 -> 연결 할 때

        // 연결 안 했으면? -> 다음번에 되는거 안되는거 둘 다 가능
        // 연결 했으면? -> 무조건 쉬어야함
        for(int i=1;i<input-1;i++){
            number[0][i] += number[0][i-1];
            number[1][i] += number[0][i-1];

            number[0][i] += number[1][i-1];

            number[0][i] %= 10;
            number[1][i] %= 10;
        }
        int answer = (int)(number[0][input-2] + number[1][input-2]);
        answer %= 10;
        System.out.println(answer);
    }
}