import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = br.readLine().trim();
        }

        StringBuilder answer = new StringBuilder();
        int totalHamming = 0;

        // 인덱스 0,1,2,3 -> A, C, G, T (사전순 우선)
        char[] order = {'A', 'C', 'G', 'T'};

        for (int col = 0; col < M; col++) {
            int[] cnt = new int[4]; // A, C, G, T
            for (int row = 0; row < N; row++) {
                char ch = strs[row].charAt(col);
                if (ch == 'A') cnt[0]++;
                else if (ch == 'C') cnt[1]++;
                else if (ch == 'G') cnt[2]++;
                else if (ch == 'T') cnt[3]++;
            }

            int maxIdx = 0;
            int maxCnt = cnt[0];
            // A, C, G, T 순으로 확인하므로 동률이면 사전순(인덱스 작음) 유지
            for (int k = 1; k < 4; k++) {
                if (cnt[k] > maxCnt) {
                    maxCnt = cnt[k];
                    maxIdx = k;
                }
            }

            answer.append(order[maxIdx]);
            totalHamming += (N - maxCnt);
        }

        System.out.println(answer.toString());
        System.out.println(totalHamming);
    }
}