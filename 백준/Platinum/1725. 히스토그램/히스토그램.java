
import java.io.*;
import java.util.*;

public class Main {
    static int[] heights;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));


        int n = Integer.parseInt(br.readLine());


        heights = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            heights[i] = Integer.parseInt(br.readLine());
        }

        // 최대 넓이 계산 후 BufferedWriter 사용하여 출력
        bw.write(getMaxArea(1, n) + "\n");

        // 출력 버퍼 비우고 닫기
        bw.flush();
        bw.close();
    }

    private static long getMaxArea(int start, int end) {
        if (start == end) {
            return heights[start];
        }
        int mid = (start + end) / 2;
        long maxArea = Math.max(getMaxArea(start, mid), getMaxArea(mid + 1, end));
        long midArea = getMidArea(start, end, mid);

        maxArea = Math.max(maxArea, midArea);
        return maxArea;
    }

    private static long getMidArea(int left, int right, int mid) {
        // left : 왼쪽 끝
        // right : 오른쪽 끝
        int low = mid;
        int high = mid;
        long minHeight = heights[mid];
        long maxArea = heights[mid];

        while (left < low || high < right) {
            if (left < low && (high == right || heights[low - 1] > heights[high + 1])) {
                low--;
                minHeight = Math.min(minHeight, heights[low]);
            } else {
                high++;
                minHeight = Math.min(minHeight, heights[high]);
            }
            maxArea = Math.max(maxArea, minHeight * (high - low + 1));
        }

        return maxArea;
    }
}
