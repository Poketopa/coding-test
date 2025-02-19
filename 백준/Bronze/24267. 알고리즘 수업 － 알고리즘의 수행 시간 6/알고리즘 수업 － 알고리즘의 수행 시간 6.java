import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine()); // 입력값
        long result = (n * (n - 1) * (n - 2)) / 6; // ✅ 조합 공식 nC3 사용

        System.out.println(result);
        System.out.println("3"); // ✅ 최고차항 차수는 항상 3
    }
}
