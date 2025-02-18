import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int column = Integer.parseInt(st.nextToken());
        int row = Integer.parseInt(st.nextToken());
        int inputBlock = Integer.parseInt(st.nextToken());
        int[][] map = new int[column][row];

        int minHeight = 256, maxHeight = 0;

        // 입력 및 최소, 최대 높이 찾기
        for (int i = 0; i < column; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            for (int j = 0; j < row; j++) {
                map[i][j] = Integer.parseInt(st2.nextToken());
                minHeight = Math.min(minHeight, map[i][j]);
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int minTime = Integer.MAX_VALUE;
        int minY = 0;

        // ✅ 최소 높이부터 최대 높이까지만 검사 (불필요한 0~256 전체 탐색 제거)
        x:
        for (int y = minHeight; y <= maxHeight; y++) {
            int block = inputBlock;
            int time = 0;

            for (int i = 0; i < column; i++) {
                for (int j = 0; j < row; j++) {
                    int temp = y - map[i][j];

                    if (temp > 0) { // 블록을 추가해야 하는 경우
                        block -= temp;
                        time += temp;
                    } else if (temp < 0) { // 블록을 제거해야 하는 경우
                        time += (-temp * 2);
                        block += (-temp); // ✅ 제거한 블록을 인벤토리에 추가해야 함!
                    }
                }
            }

            // ✅ 블록이 부족하면 더 이상 탐색할 필요 없음
            if (block < 0) continue x;

            // ✅ 최소 시간 및 높은 높이 선택
            if (time < minTime || (time == minTime && y > minY)) { 
                minTime = time;
                minY = y;
            }
        }

        System.out.println(minTime + " " + minY);
    }
}
