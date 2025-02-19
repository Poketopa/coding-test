import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int a1 = Integer.parseInt(st.nextToken()); // ✅ a1
        int a0 = Integer.parseInt(st.nextToken()); // ✅ a0
        int c = Integer.parseInt(br.readLine()); // ✅ c
        int n0 = Integer.parseInt(br.readLine()); // ✅ n0

        // ✅ O(n) 정의를 만족하는지 확인
        if (a1 <= c && (a1 * n0 + a0) <= (c * n0)) {
            System.out.println("1");
        } else {
            System.out.println("0");
        }
    }
}
